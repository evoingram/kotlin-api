package com.example.kotlinapipg1.impls

import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.services.KafkaService

class KafkaRepositoryImpl : KafkaRepository {

    private val kafkaService = KafkaService()
    override fun produceMessage(topic: String): String = kafkaService.produceMessage(topic)

    override fun consumeMessage(topic: String): String = kafkaService.consumeMessage(topic)

    override fun keepRecords() = kafkaService.keepRecords()
}
