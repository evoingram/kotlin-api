package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.services.UsersService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(val usersService: UsersService) {
    @GetMapping("/users")
    fun index(): List<User> = usersService.findUsers()

    @GetMapping("/users/{usersId}")
    fun findUserByUsersId(@PathVariable usersId: String) = usersService.findUserByUsersId(usersId)

    @GetMapping("/users/{usersId}/all")
    fun findAllByUsersId(@PathVariable usersId: String) = usersService.findAllByUsersId(usersId)

    @GetMapping("/users/{usersId}/exists")
    fun existsByUsersId(@PathVariable usersId: String) = usersService.existsByUsersId(usersId)

    @GetMapping("/users/email/{email}")
    fun findUserByEmail(@PathVariable email: String): User =
        usersService.findUserByEmail(email)

    @GetMapping("/users/username/{username}")
    fun findUserByUsername(@PathVariable username: String): User = usersService.findUserByUsername(username)

    @DeleteMapping("/users/{usersId}")
    fun deleteByUsersId(@PathVariable usersId: String) = usersService.deleteByUsersId(usersId)

    @PostMapping("/users/")
    fun post(@RequestBody user: User) = usersService.save(user)
}
