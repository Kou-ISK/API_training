package com.example.api_training.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriUtils

// https://dashboard.e-stat.go.jp/static/api
// https://www.e-stat.go.jp/api/api-info/e-stat-manual
@Service
class StatsRestTemplate(
    val restTemplate: RestTemplate,
) {
    @Value("\${e_stat.api.json.APPLICATION_ID}")
    var appId = ""

    // TODO statsListから任意のstatsDataIdを取得する
    var statsDataId = "0000081942"

    // TODO レスポンス用のモデルを作成
    // 統計データ取得
    fun getStatsData() {
        val statsResponse =
            restTemplate.getForObject(
                "/getStatsData/?appId=${appId}&statsDataId=${statsDataId}", String::class.java
            )
        println(statsResponse)
    }

    // 統計表情報取得
    fun getStatsList() {
        val statsList =
            restTemplate.getForObject(
                "/getStatsList/?appId=${appId}&surveyYears=1998&statsCode=00200522",
                String::class.java
            )
        println(statsList)
    }
}