package com.example.api_training.controller

import com.example.api_training.model.UserModel
import com.example.api_training.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
class UserController(
    var service: UserService) {

    @PostMapping("/api/users")
    fun createUser(@RequestBody user:UserModel){
        service.createUser(user)
    }

    @GetMapping("api/users/{id}")
    fun getUser(@PathVariable id:String){
        val user = service.findUser(id)
        println(user)
    }
}