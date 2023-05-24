package com.example.kotlinapipg1.repositories

interface KafkaRepository {
    fun produceCustomersMessage(): String

    fun consumeCustomersMessage(): String

    fun keepRecords()
}
