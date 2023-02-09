package com.example.api_training.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class UserModel(
    @JsonProperty("id")
    val userId: Int?,
    @JsonProperty("name")
    val userName: String?,
    @JsonProperty("email")
    val email: String?
)