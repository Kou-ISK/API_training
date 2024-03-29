package com.example.api_training.controller

import com.example.api_training.model.DateTimeModel
import com.example.api_training.model.UserModel
import com.example.api_training.model.XmlSample
import com.example.api_training.service.StatsRestTemplate
import com.example.api_training.service.UserService
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/")
class UserController(
    val service: UserService,
    val restTemplate: StatsRestTemplate,
) {
    @PostMapping("/users/add")
    fun createUser(
        @RequestBody user: UserModel,
    ): UserModel {
        service.createUser(user)
        return user
    }

    @GetMapping("/user/{id}")
    fun findUserById(@PathVariable("id") id: Int): UserModel {
        val user = service.findUserById(id)
        println(user)
        return user
    }

    @GetMapping("/user")
    fun findAllUser(): List<UserModel> {
        return service.findAllUser()
    }

    @DeleteMapping("/delete_user/{id}")
    fun deleteUserById(@PathVariable("id") id: Int): String {
        service.deleteUserById(id)
        return "削除しました"
    }

    @PatchMapping("/update_user/{id}")
    fun updateUser(@PathVariable("id") id: Int, @RequestBody newUserData: UserModel): UserModel {
        val user = UserModel(id, newUserData.userName, newUserData.email)
        return service.updateUser(user)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World."
    }

    @GetMapping("/return_xml")
    fun returnXML(): String {
        val xmlMapper = XmlMapper()
        val xml = xmlMapper.writeValueAsString(XmlSample())
        return xml
    }

    @GetMapping("/test/api")
    fun testAPI() {
        restTemplate.getStatsList()
        restTemplate.getStatsData()
    }


    @GetMapping("/list_check")
    fun listCheck() {
        service.listCheck()
    }

    @PostMapping("/date_time_check")
    fun dateTimeCheck(@RequestBody dateTime: DateTimeModel) {
        service.dateTimeCheck(dateTime)
    }
}