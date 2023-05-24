package com.example.kotlinapipg1.impls

import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.services.KafkaService

class KafkaRepositoryImpl : KafkaRepository {
    override fun produceCustomersMessage(): String {
        val kafkaService = KafkaService()
        return kafkaService.produceCustomersMessage()
    }
}
