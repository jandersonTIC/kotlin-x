package com.twitter.controller

import com.twitter.service.TwitterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/twitter")
class TwitterController(private val twitterService: TwitterService) {

    @GetMapping("/timeline")
    fun getHomeTimeline(@RequestParam(defaultValue = "10") count: Int): List<Map<String, Any>> {
        return twitterService.getHomeTimeline(count)
    }

    @GetMapping("/user")
    fun getUserTimeline(
        @RequestParam screenName: String,
        @RequestParam(defaultValue = "10") count: Int
    ): List<Map<String, Any>> {
        return twitterService.getUserTimeline(screenName, count)
    }
} 