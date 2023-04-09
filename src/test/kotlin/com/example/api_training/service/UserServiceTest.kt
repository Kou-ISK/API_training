package com.example.api_training.service

import com.example.api_training.model.UserModel
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
@Sql("classpath:db/testdata/user_testdata.sql")
class UserServiceTest {
    private companion object {
        val user = UserModel(userId = 1, userName = "田中", email = "tanakatanaka@tanaka.com")
    }

    @Autowired
    lateinit var service: UserService

    @Nested
    inner class testCreate {
        @Test
        @DisplayName("登録　正常系")
        fun createUserTest() {
            /**
             * Arrange
             */
            val name = "あ".repeat(100)
            val expectedUser = user.copy(userName = name)

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
        @DisplayName("登録　異常系（Null）")
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
        @DisplayName("登録　異常系（空文字）")
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
        @DisplayName("登録　異常系（文字数オーバー）")
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

    @Nested
    inner class testFind {
        @Test
        @DisplayName("取得　正常系")
        fun findUserByIdTest() {
            /**
             * Arrange
             */
            val expected = user.copy()

            /**
             * ACT
             */
            val actual = service.findUserById(expected.userId!!)
            /**
             * Assert
             */
            assertEquals("ユーザーID", expected.userId, actual.userId)
            assertEquals("ユーザー名", expected.userName, actual.userName)
            assertEquals("メールアドレス", expected.email, actual.email)
        }

        @Test
        @DisplayName("取得　異常系(該当項目なし)")
        fun findUserByIdTest_fail_not_found() {
            /**
             * Assert
             */
            assertThrows<Exception> { service.findUserById(404) }
        }
    }
}