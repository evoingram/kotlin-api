package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String> {
    fun findAllById(id: String): MutableIterable<Message>
}
