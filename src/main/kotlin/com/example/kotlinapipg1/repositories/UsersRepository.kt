package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.User
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, String> {
    fun findAllByUsersId(usersId: String): MutableIterable<User>

    fun findByUsersId(usersId: String): List<User>

    @Modifying
    @Query("UPDATE users SET username = :username, email = :email WHERE usersId = :usersId")
    fun updateUserByUsersId(usersId: String, username: String, email: String)

    fun deleteByUsersId(usersId: String)

    fun existsByUsersId(usersId: String?)
}
