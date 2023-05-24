package com.example.kotlinapipg1.repositories

interface KafkaRepository {
    fun produceCustomersMessage(): String
}
