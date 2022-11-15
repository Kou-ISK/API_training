package com.example.api_training.controller

import com.example.api_training.model.UserModel
import com.example.api_training.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UserController (val service: UserService){
    @PostMapping("/users/add")
    fun createUser(
                   @RequestParam("name") name:String,
                   @RequestParam("email") email:String){
        val user= UserModel(null,name,email)
        return service.createUser(user)
    }

    @GetMapping("/users")
    fun findUserById(@RequestParam("id") id:Int):UserModel{
        val user = service.findUserById(id)
        println(user)
        return user
    }

    @GetMapping("/hello")
    fun hello(): String{
        return "Hello World."
    }
}