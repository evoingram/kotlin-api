package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class UserTest {
    private val usersId: UUID = UUID.randomUUID()

    val mockUser1 = User(
        usersId.toString(),
        "buttercup",
        "email@email.com",
    )

    val mockUser2 = User(
        usersId.toString(),
        "buttercup",
        "email@email.com",
    )

    @Test
    @DisplayName("test User data class")
    fun `test User data class`() {
        Assertions.assertEquals(usersId.toString(), mockUser1.usersId)
        Assertions.assertEquals("buttercup", mockUser1.username)
        Assertions.assertEquals("email@email.com", mockUser1.email)
    }

    @Test
    @DisplayName("test User data class equality")
    fun `test User data class equality`() {
        Assertions.assertEquals(mockUser1, mockUser2)
    }
}
