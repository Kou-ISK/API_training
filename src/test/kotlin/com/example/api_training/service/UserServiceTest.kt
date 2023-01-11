package com.example.api_training.service

import com.example.api_training.model.UserModel
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.util.AssertionErrors.assertNotEquals
import org.springframework.transaction.annotation.Transactional



class UserServiceTest{
    @Autowired
    private lateinit var service: UserService

    @Test
    @Transactional
    fun createUserTest(){
        /**
         * Arrange
         */
        val user1 = UserModel(userId=1,userName="田中", email = "tanakatanaka@tanaka.com")
        val user2 = UserModel(userId= 1,userName="山田", email = "yamadayamada@yamada.com")
        /**
         * Act
         */
        val user1Actual = service.createUser(user1)
        val user2Actual = service.createUser(user2)
        /**
         * Assert
         */
        assertEquals("正常系",user1,user1Actual)
        assertEquals("異常系",user2,user2Actual)
        assertNotEquals("異常系",user1,user2Actual)
    }

}