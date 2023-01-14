package com.example.api_training.service

import com.example.api_training.mapper.UserMapper
import com.example.api_training.model.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var mapper: UserMapper
    fun createUser(user: UserModel): UserModel {
        //名前、メールアドレス文字数チェック
        checkNameEmailLength(user)
        checkNameEmailEmpty(user)
        mapper.createUser(user)
        return user
    }

    fun findUserById(id: Int): UserModel {
        val user = mapper.findUserById(id) ?: throw Exception("指定したIDに紐づくユーザーが存在しません")
        return user
    }

    fun updateUser(user: UserModel) {
        checkNameEmailLength(user)
        checkNameEmailEmpty(user)
        checkUserExistence(user.userId!!)
        return mapper.updateUser(user)
    }

    fun deleteUserById(id: Int) {
        checkUserExistence(id)
        mapper.deleteUserById(id)
    }

    fun findAllUser(): List<UserModel> {
        return mapper.findAllUser()
    }

    fun checkUserExistence(id: Int) {
        if (findUserById(id) == null) {
            throw Exception("指定したIDに紐づくユーザーが存在しません")
        }
    }

    fun checkNameEmailLength(user: UserModel) {
        if (user.userName != null && user.email != null) {
            if (user.userName.length > 100 || user.email.length > 100) {
                throw Exception("名前もしくはメールアドレスが文字数上限を超過しています")
            }
        }
    }

    fun checkNameEmailEmpty(user: UserModel) {
        if (user.userName != null || user.email != null) {
            if (user.userName == "" || user.email == "") {
                throw Exception("名前もしくはメールアドレスが不正です")
            }
        } else {
            throw Exception("名前もしくはメールアドレスが不正です")
        }
    }
}