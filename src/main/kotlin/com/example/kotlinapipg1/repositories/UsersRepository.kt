package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.User
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, String> {
    fun findAllByUsersId(usersId: String): MutableIterable<User>

    fun findByUsersId(usersId: String): List<User>

    fun deleteByUsersId(usersId: String)

    fun existsByUsersId(usersId: String)
}
