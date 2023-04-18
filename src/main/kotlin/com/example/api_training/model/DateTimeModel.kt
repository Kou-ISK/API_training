package com.example.api_training.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime


@JsonSerialize
data class DateTimeModel(
    @DateTimeFormat(pattern = "yyyyMMdd")
    @JsonProperty("local_date_time")
    var localDateTime: LocalDateTime?,
    @DateTimeFormat(pattern = "yyyyMMdd")
    @JsonProperty("local_date")
    var localDate: LocalDate?,
    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asita/Tokyo")
    @JsonProperty("offset_date_time")
    var offsetDateTime: OffsetDateTime?,
    @DateTimeFormat(pattern = "yyyyMMdd")
    @JsonProperty("timestamp")
    var timeStamp: Timestamp?,
)