package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.kafka.KafkaConsumer
import com.example.kotlinapipg1.kafka.KafkaProducer
import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.utils.Constants.BROKER_ADDRESS
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

    override fun produceMessage(topic: String): String {
        logger.info("produceMessage is running.  Sending test item for $topic to producer.")
        kafkaProducer.produce(BROKER_ADDRESS, topic)
        consumeMessage(topic)
        return "Kafka message for topic $topic were sent to producer."
    }

    override fun consumeMessage(topic: String): String {
        kafkaConsumer.subscribe(listOf(topic))
        logger.info("Kafka message consumed for item on topic $topic")
        keepRecords()
        return "Kafka message for items on $topic was consumed."
    }

    override fun keepRecords() {
        logger.info("keepRecords is running")
        val records = kafkaConsumer.poll(Duration.ofSeconds(1))
        logger.info("${records.count()} = number of records")
        records.forEach { record ->
            val recordJson: Any = record.value()
            logger.info("customer JSON = $recordJson")
        }
        logger.info("All kafka records consumed.")
    }
}
