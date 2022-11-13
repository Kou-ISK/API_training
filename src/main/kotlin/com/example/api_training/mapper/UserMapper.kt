package com.example.api_training.mapper
import com.example.api_training.model.UserModel
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    @Override
    fun createUser(user:UserModel)
    @Override
    fun findUserById(id:String):UserModel
}