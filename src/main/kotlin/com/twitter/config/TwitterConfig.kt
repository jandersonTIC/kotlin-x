package com.twitter.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "twitter")
class TwitterConfig {
    var apiKey: String = ""
    var apiKeySecret: String = ""
    var accessToken: String = ""
    var accessTokenSecret: String = ""
    var bearerToken: String = ""
} 