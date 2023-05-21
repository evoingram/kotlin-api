package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.repositories.UsersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersService(val db: UsersRepository) {
    fun findUsers(): List<User> = db.findAll().toList()

    fun findUserByUsersId(id: String): List<User> = db.findByUsersId(id).toList()

    fun save(message: User) {
        db.save(message)
    }

    fun findAllByUsersId(id: String) = db.findAllByUsersId(id)

    fun deleteByUsersId(id: String) = db.deleteByUsersId(id)

    fun existsByUsersId(id: String) = db.existsByUsersId(id)

    fun findUserByEmail(email: String): User =
        db.findAll().filter { it.email == email }[0]

    fun findUserByUsername(username: String): User = db.findAll().filter { it.username == username }[0]

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
