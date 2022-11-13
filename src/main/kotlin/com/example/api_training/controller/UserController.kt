package com.example.api_training.controller

import com.example.api_training.model.UserModel
import com.example.api_training.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController{
    @Autowired
    private lateinit var service: UserService
    @PutMapping("/users")
    fun createUser(@RequestBody user:UserModel){
        return service.createUser(user)
    }

    @GetMapping("/users/{id}")
    fun findUserById(@PathVariable("id") id:String):UserModel{
        val user = service.findUserById(id)
        println(user.userName)
        return user
    }

    @GetMapping("/hello")
    fun hello(): String{
        return "Hello World."
    }
}