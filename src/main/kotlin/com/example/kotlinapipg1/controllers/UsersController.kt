package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.User
import com.example.kotlinapipg1.dataClasses.UserRequest
import com.example.kotlinapipg1.services.UsersService
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/users/{usersId}")
    fun updateUserByUsersId(@PathVariable usersId: String, @RequestBody userRequest: UserRequest): String {
        val rowsUpdated = usersService.updateUserByUsersId(usersId, userRequest)
        return "Updated $rowsUpdated user(s)"
    }

    @DeleteMapping("/users/{usersId}")
    fun deleteByUsersId(@PathVariable usersId: String) = usersService.deleteByUsersId(usersId)

    @PostMapping("/users/")
    fun post(@RequestBody user: User) = usersService.save(user)
}
