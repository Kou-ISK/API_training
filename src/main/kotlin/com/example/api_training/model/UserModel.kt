package com.example.api_training.model

import org.springframework.data.annotation.Id

data class UserModel(
    @Id
    val userId:String,
    val userName:String,
    val email:String
)