package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.dataClasses.UserRequest
import com.example.kotlinapipg1.repositories.UsersRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UsersServiceTest {

    @Mock
    private lateinit var usersRepository: UsersRepository

    private final val usersId = UUID.randomUUID().toString()
    val testUser1 = User(usersId, "John Doe", "email@email.com")
    val testUser2 = User(usersId, "buttercup", "buttercup@buttercup.com")

    @Test
    fun `test delete user by users id`() {
        `when`(usersRepository.findById(usersId)).thenReturn(Optional.of(testUser1))
        val userService = UsersService(usersRepository)
        userService.deleteByUsersId(usersId)
        verify(usersRepository).deleteByUsersId(usersId)
    }

    @Test
    fun `test exists by users id`() {
        `when`(usersRepository.findById(usersId)).thenReturn(Optional.empty())
        val userService = UsersService(usersRepository)
        userService.existsByUsersId(usersId)
        verify(usersRepository).existsByUsersId(usersId)
    }

    @Test
    fun `test find user by email`() {
        `when`(usersRepository.findAll()).thenReturn(listOf(testUser2))
        val userService = UsersService(usersRepository)
        userService.findUserByEmail(testUser2.email)
        verify(usersRepository).findAll()
    }

    @Test
    fun `test find user by username`() {
        `when`(usersRepository.findAll()).thenReturn(listOf(testUser2))
        val userService = UsersService(usersRepository)
        userService.findUserByUsername(testUser2.username)
        verify(usersRepository).findAll()
    }

    @Test
    fun `test find users`() {
        val userService = UsersService(usersRepository)
        `when`(usersRepository.findAll()).thenReturn(listOf(testUser2))
        userService.findUsers()
        verify(usersRepository).findAll()
    }

    @Test
    fun `test find users by users id`() {
        val userService = UsersService(usersRepository)
        `when`(usersRepository.findByUsersId(usersId)).thenReturn(listOf(testUser1))
        userService.findUserByUsersId(usersId)
        verify(usersRepository).findByUsersId(usersId)
    }

    @Test
    fun `test find all by users id`() {
        val userService = UsersService(usersRepository)
        `when`(usersRepository.findAllByUsersId(usersId)).thenReturn(mutableListOf(testUser1))
        userService.findAllByUsersId(usersId)
        verify(usersRepository).findAllByUsersId(usersId)
    }

    @Test
    fun `test saving user to database`() {
        val userService = UsersService(usersRepository)
        `when`(usersRepository.save(testUser1)).thenReturn(testUser1)
        val savedUser = userService.save(testUser1)
        Assertions.assertEquals(testUser1, savedUser)
        verify(usersRepository).save(testUser1)
    }

    @Test
    fun `test updating user`() {
        val userService = UsersService(usersRepository)
        doNothing().`when`(usersRepository)
            .updateUserByUsersId(testUser1.usersId.toString(), "buttercup1", "buttercup@email.com")
        userService.updateUserByUsersId(testUser1.usersId.toString(), UserRequest("buttercup1", "buttercup@email.com"))
        verify(usersRepository).updateUserByUsersId(testUser1.usersId.toString(), "buttercup1", "buttercup@email.com")
    }
}
