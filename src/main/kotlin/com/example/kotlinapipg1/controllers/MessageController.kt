package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Message
import com.example.kotlinapipg1.services.MessageService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(val messageService: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = messageService.findMessages()

    @GetMapping("/{id}")
    fun findAllById(@PathVariable id: String) = messageService.findAllById(id)

    @GetMapping("/{id}/exists")
    fun existsById(@PathVariable id: String) = messageService.existsById(id)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String) = messageService.deleteById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) = messageService.save(message)
}
