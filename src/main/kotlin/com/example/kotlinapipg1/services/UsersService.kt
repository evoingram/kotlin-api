package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.dataClasses.UserRequest
import com.example.kotlinapipg1.repositories.UsersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersService(val db: UsersRepository) {
    fun findUsers(): List<User> = db.findAll().toList()

    fun findUserByUsersId(usersId: String): List<User> = db.findByUsersId(usersId).toList()

    fun save(message: User) {
        db.save(message)
    }

    fun findAllByUsersId(usersId: String) = db.findAllByUsersId(usersId)

    fun updateUserByUsersId(usersId: String, userRequest: UserRequest) =
        userRequest.username?.let { username ->
            userRequest.email?.let { email ->
                db.updateUserByUsersId(usersId, username, email)
            }
        }

    fun deleteByUsersId(usersId: String) = db.deleteByUsersId(usersId)

    fun existsByUsersId(usersId: String) = db.existsByUsersId(usersId)

    fun findUserByEmail(email: String): User =
        db.findAll().filter { it.email == email }[0]

    fun findUserByUsername(username: String): User = db.findAll().filter { it.username == username }[0]

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
