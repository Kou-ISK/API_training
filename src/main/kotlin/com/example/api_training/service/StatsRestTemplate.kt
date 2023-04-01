package com.example.api_training.service

import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

// https://dashboard.e-stat.go.jp/static/api
@Service
class StatsRestTemplate(
    val restTemplate: RestTemplate,
) {
    fun request(): ResponseEntity<String> {
        //リクエストの送信
        val response =
            restTemplate.exchange(
                "/getData/?Lang=JP&IndicatorCode=0201010000000010000",
                HttpMethod.GET,
                null,
                String::class.java
            )
        println(response)
        println("===================================${response}=================")
        return response
    }
}