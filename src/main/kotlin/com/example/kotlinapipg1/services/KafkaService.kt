package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.kafka.KafkaConsumer
import com.example.kotlinapipg1.kafka.KafkaProducer
import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.utils.Constants.BROKER_ADDRESS
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import mu.two.KotlinLogging
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class KafkaService : KafkaRepository {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    val kafkaProducer = KafkaProducer()
    val kafkaConsumer = KafkaConsumer().createConsumer(
        BROKER_ADDRESS,
    )

    override fun produceMessage(topic: String, data: Any): String {
        val customer = kafkaProducer.serializeCustomer(DataGenerator.testCustomer1)
        kafkaProducer.produceCustomer(BROKER_ADDRESS, data)
        consumeMessage(topic)
        return "Kafka message for topic $CUSTOMERS_TOPIC were sent to producer."
    }

    override fun consumeMessage(topic: String): String {
        kafkaConsumer.subscribe(listOf(topic))
        logger.info("Kafka message consumed for customer1 & customer2 on topic $topic")
        keepRecords()
        return "Kafka message for customers was consumed."
    }

    override fun keepRecords() {
        logger.info("keepRecords is running")
        val records = kafkaConsumer.poll(Duration.ofSeconds(1))
        logger.info("$records = number of records")
        records.forEach { record ->
            val recordJson = record.value()
            logger.info("customer JSON = $recordJson")
        }
        logger.info("All kafka records consumed.")
    }
}
