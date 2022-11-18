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
        println("registration success")
        return mapper.createUser(user)
    }
    fun findUserById(id:Int):UserModel{
        return mapper.findUserById(id)
    }

    fun deleteUserById(id: Int){
        mapper.deleteUserById(id)
    }
    fun findAllUser():List<UserModel>{
        return mapper.findAllUser()
    }
}