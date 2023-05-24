package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.kafka.KafkaProducer
import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.utils.Constants.BROKER_ADDRESS
import org.springframework.stereotype.Service

@Service
class KafkaService : KafkaRepository {

    override fun produceCustomersMessage(): String {
        val kafkaProducer = KafkaProducer()
        kafkaProducer.serializeAndProduce(BROKER_ADDRESS)
        return "Kafka message for customers were sent to producer."
    }
}
