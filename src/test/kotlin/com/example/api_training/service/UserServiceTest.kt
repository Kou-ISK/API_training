package com.example.api_training.service

import com.example.api_training.model.UserModel
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserServiceTest() {
    private companion object {
        val user = UserModel(userId = 1, userName = "田中", email = "tanakatanaka@tanaka.com")
    }
    @Autowired
    lateinit var service: UserService

    @Test
    @DisplayName("ユーザー登録（正常系）")
    fun createUserTest() {
        /**
         * Arrange
         */
        val name = "あ".repeat(100)
        val expectedUser = user.copy(userName=name)
        /**
         * Act
         */
        val actualUser = service.createUser(expectedUser)
        /**
         * Assert
         */
        assertEquals("ユーザー名", expectedUser.userName, actualUser.userName)
        assertEquals("メールアドレス", expectedUser.email, actualUser.email)
    }

    @Test
    @DisplayName("Null登録失敗（異常系）")
    fun createUserTest_fail_null() {
        /**
         * Arrange
         */
        val expectedUser = user.copy(userId = null, userName = null, email = null)
        /**
         * Act, Assert
         */
        assertThrows<Exception> {
            service.createUser(expectedUser)
        }
    }

    @Test
    @DisplayName("空文字登録失敗（異常系）")
    fun createUserTest_fail_empty() {
        /**
         * Arrange
         */
        val expectedUser = user.copy(userId = null, userName = "", email = "")
        /**
         * Act, Assert
         */
        assertThrows<Exception> {
            service.createUser(expectedUser)
        }
    }

    @Test
    @DisplayName("文字数オーバー登録失敗（異常系）")
    fun createUserTest_fail_name_limit_over() {
        /**
         * Arrange
         */
        val name = "あ".repeat(101)
        val expectedUser = user.copy(userId = null, userName = name)
        /**
         * Act, Assert
         */
        assertThrows<Exception> {
            service.createUser(expectedUser)
        }
    }
    }