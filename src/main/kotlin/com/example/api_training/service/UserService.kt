package com.example.api_training.service

import com.example.api_training.mapper.UserMapper
import com.example.api_training.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService{
    @Autowired
    lateinit var mapper: UserMapper
    fun createUser(user: UserModel){
        return mapper.createUser(user)
    }
    fun findUserById(id:String):UserModel{
        return mapper.findUserById(id)
    }
}