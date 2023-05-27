package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.dataClasses.UserRequest
import com.example.kotlinapipg1.services.UsersService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UsersControllerTest {

    @Mock
    lateinit var usersService: UsersService

    private final val usersId1 = UUID.randomUUID().toString()

    val testUser = User(
        usersId1,
        "buttercup",
        "buttercup@email5.com"
    )

    @Test
    fun `test GET users`() {
        val userController = UsersController(usersService)
        val expected = mutableListOf(testUser)
        `when`(usersService.findUsers()).thenReturn(expected)
        val response = userController.index()
        verify(usersService).findUsers()
        assertEquals(response, expected)
    }

    @Test
    fun `test GET users slash {usersId}`() {
        val userController = UsersController(usersService)
        val expected = mutableListOf(testUser)
        `when`(usersService.findUserByUsersId(usersId1)).thenReturn(expected)
        val response = userController.findUserByUsersId(usersId1)
        verify(usersService).findUserByUsersId(usersId1)
        assertEquals(response, expected)
    }

    @Test
    fun `test GET users slash {usersId} slash all`() {
        val userController = UsersController(usersService)
        val expected = mutableListOf(testUser)
        `when`(usersService.findAllByUsersId(usersId1)).thenReturn(expected)
        val response = userController.findAllByUsersId(usersId1)
        verify(usersService).findAllByUsersId(usersId1)
        assertEquals(response, expected)
    }

    @Test
    fun `test GET users slash {usersId} slash exists`() {
        val userController = UsersController(usersService)
        doNothing().`when`(usersService).existsByUsersId(usersId1)
        val response = userController.existsByUsersId(usersId1)
        verify(usersService).existsByUsersId(usersId1)
        assertEquals(response, Unit)
    }

    @Test
    fun `test GET users slash phoneNumber slash {phoneNumber}`() {
        val userController = UsersController(usersService)
        `when`(usersService.findUserByEmail(usersId1)).thenReturn(testUser)
        val response = userController.findUserByEmail(usersId1)
        verify(usersService).findUserByEmail(usersId1)
        assertEquals(response, testUser)
    }

    @Test
    fun `test GET users slash company slash {company}`() {
        val userController = UsersController(usersService)
        `when`(usersService.findUserByUsername(usersId1)).thenReturn(testUser)
        userController.findUserByUsername(usersId1)
        verify(usersService).findUserByUsername(usersId1)
    }

    @Test
    fun `test PUT users slash {usersId}`() {
        val userController = UsersController(usersService)
        val userRequest = UserRequest("buttercup99", "buttercup@email1.com")
        `when`(usersService.updateUserByUsersId(usersId1, userRequest)).thenReturn(Unit)
        val response = userController.updateUserByUsersId(testUser.usersId.toString(), userRequest)
        verify(usersService).updateUserByUsersId(testUser.usersId.toString(), userRequest)
        assertEquals(response, "Updated kotlin.Unit user(s)")
    }

    @Test
    fun `test DELETE users slash {usersId}`() {
        val userController = UsersController(usersService)
        val response = userController.deleteByUsersId(usersId1)
        verify(usersService).deleteByUsersId(usersId1)
        assertEquals(response, Unit)
    }


    @Test
    fun `test POST users slash {usersId}`() {
        val userController = UsersController(usersService)
        `when`(usersService.save(testUser)).thenReturn(testUser)
        val response = userController.post(testUser)
        verify(usersService).save(testUser)
        assertEquals(response, testUser)
    }
}
