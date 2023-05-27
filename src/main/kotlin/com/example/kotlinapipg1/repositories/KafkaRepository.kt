package com.example.kotlinapipg1.repositories

interface KafkaRepository {
    fun produceMessage(topic: String): String

    fun consumeMessage(topic: String): String

    fun keepRecords()
}
