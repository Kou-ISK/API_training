package com.example.api_training.mapper
import com.example.api_training.model.UserModel
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun save(user:UserModel)
    fun read(id:String):UserModel
}