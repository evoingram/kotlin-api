package com.example.kotlinapipg1.dataClasses

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserRequestTest {
    private val mockUserRequest1 = UserRequest(
        "buttercup",
        "email@email.com"
    )

    private val mockUserRequest2 = UserRequest(
        "buttercup",
        "email@email.com"
    )

    @Test
    @DisplayName("test UserRequest data class")
    fun `test UserRequest data class`() {
        Assertions.assertEquals("buttercup", mockUserRequest1.username)
        Assertions.assertEquals("email@email.com", mockUserRequest1.email)
    }

    @Test
    @DisplayName("test UserRequest data class equality")
    fun `test UserRequest data class equality`() {
        Assertions.assertEquals(mockUserRequest1, mockUserRequest2)
    }
}