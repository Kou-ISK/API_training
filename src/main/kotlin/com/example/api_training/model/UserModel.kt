package com.example.api_training.model

import org.springframework.stereotype.Repository

@Repository
data class UserModel(
    val userId:String,
    val userName:String,
    val email:String
)