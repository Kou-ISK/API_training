package com.example.api_training.service

import com.example.api_training.mapper.UserMapper
import com.example.api_training.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService{
    @Autowired
    lateinit var mapper: UserMapper
    fun createUser(user: UserModel):UserModel{
        println("registration success")
        mapper.createUser(user)
        return user
    }
    fun findUserById(id:Int):UserModel{
        return mapper.findUserById(id)
    }

    fun updateUser(user: UserModel){
        return mapper.updateUser(user)
    }

    fun deleteUserById(id: Int){
        mapper.deleteUserById(id)
    }
    fun findAllUser():List<UserModel>{
        return mapper.findAllUser()
    }

//    TODO Validationの追加
}