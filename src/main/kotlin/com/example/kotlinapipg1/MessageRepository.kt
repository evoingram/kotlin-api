package com.example.kotlinapipg1

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>
