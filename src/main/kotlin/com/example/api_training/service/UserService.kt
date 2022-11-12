package com.example.api_training.service

import com.example.api_training.model.UserModel
import com.example.api_training.mapper.UserMapper
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService (var mapper: UserMapper){
    fun createUser(user:UserModel){
        mapper.save(user)
    }
    fun findUser(id:String):UserModel{
        return mapper.read(id)
    }
}