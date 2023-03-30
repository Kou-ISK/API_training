package com.example.api_training.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

// https://dashboard.e-stat.go.jp/static/api
@Service
class StatsRestTemplate {
    @Autowired
    var restTemplate: RestTemplate? = null

    @Value("\${e_stat.api.json.REGION_INFO_PATH}")
    var url = ""

    fun request(): ResponseEntity<String>? {
        //リクエストの送信
        val response = restTemplate?.exchange(url, HttpMethod.GET, null, String::class.java)
        println(url)
        println("===================================${response}=================")
        return response
    }
}