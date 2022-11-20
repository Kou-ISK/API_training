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
                   @RequestBody user:UserModel){
        return service.createUser(user)
    }

    @GetMapping("/user/{id}")
    fun findUserById(@PathVariable("id") id:Int):UserModel{
        val user = service.findUserById(id)
        println(user)
        return user
    }

    @GetMapping("/user")
    fun findAllUser():List<UserModel>{
        return service.findAllUser()
    }

    @DeleteMapping("/delete_user/{id}")
    fun deleteUserById(@PathVariable("id") id:Int):String{
        service.deleteUserById(id)
        return "削除しました"
    }

    @PutMapping("/update_user/{id}")
    fun updateUser(@PathVariable("id") id: Int, @RequestBody newUserData: UserModel):UserModel{
        val user = UserModel(id,newUserData.userName,newUserData.email)
        service.updateUser(user)
        return user
    }

    @GetMapping("/hello")
    fun hello(): String{
        return "Hello World."
    }
}