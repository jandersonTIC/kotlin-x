package com.twitter.service

import com.twitter.config.TwitterConfig
import org.springframework.stereotype.Service
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

@Service
class TwitterService(private val twitterConfig: TwitterConfig) {
    
    private val twitter: Twitter by lazy {
        val configurationBuilder = ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey(twitterConfig.apiKey)
            .setOAuthConsumerSecret(twitterConfig.apiKeySecret)
            .setOAuthAccessToken(twitterConfig.accessToken)
            .setOAuthAccessTokenSecret(twitterConfig.accessTokenSecret)
        
        TwitterFactory(configurationBuilder.build()).instance
    }

    fun getUserTimeline(screenName: String, count: Int = 10): List<Map<String, Any>> {
        return try {
            twitter.getUserTimeline(screenName)
                .take(count)
                .map { tweet ->
                    mapOf(
                        "id" to tweet.id,
                        "text" to tweet.text,
                        "createdAt" to tweet.createdAt,
                        "favoriteCount" to tweet.favoriteCount,
                        "retweetCount" to tweet.retweetCount
                    )
                }
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch tweets: ${e.message}", e)
        }
    }

    fun getHomeTimeline(count: Int = 10): List<Map<String, Any>> {
        return try {
            twitter.homeTimeline
                .take(count)
                .map { tweet ->
                    mapOf(
                        "id" to tweet.id,
                        "text" to tweet.text,
                        "createdAt" to tweet.createdAt,
                        "favoriteCount" to tweet.favoriteCount,
                        "retweetCount" to tweet.retweetCount,
                        "user" to mapOf(
                            "name" to tweet.user.name,
                            "screenName" to tweet.user.screenName
                        )
                    )
                }
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch home timeline: ${e.message}", e)
        }
    }
} 