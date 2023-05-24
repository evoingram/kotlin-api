package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.repositories.UsersRepository
import org.junit.jupiter.api.Test
import org.mockito.Mock
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

    /*
    @Test
    fun `test exists user by usersId -- null user throws IllegalArgumentException`() {
        `when`(usersRepository.findById(usersId)).thenReturn(Optional.empty())
        val userService = UsersService(usersRepository)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            userService.existsByUsersId(null)
        }
        assertEquals("User not found", exception.message)
    }

    @Test
    fun `test delete user by usersId -- user not found`() {
        `when`(usersRepository.findById(usersId)).thenReturn(Optional.empty())
        val userService = UsersService(usersRepository)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            userService.deleteByUsersId(usersId)
        }
        assertEquals("User not found", exception.message)
    }

     */
}
