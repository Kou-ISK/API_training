package com.example.api_training.mapper
import com.example.api_training.model.UserModel
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun createUser(user:UserModel)

    fun findUserById(id:Int):UserModel
    fun findAllUser():List<UserModel>
}