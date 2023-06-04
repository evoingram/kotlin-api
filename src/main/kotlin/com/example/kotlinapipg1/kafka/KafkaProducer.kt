package com.example.kotlinapipg1.kafka

import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.utils.Constants.APPEARANCES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CASES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.INVOICES_TOPIC
import com.example.kotlinapipg1.utils.Constants.ORDERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.STATUSES_TOPIC
import com.example.kotlinapipg1.utils.DataSerializer
import mu.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*
import java.util.concurrent.Future

class KafkaProducer {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    private fun createProducer(brokers: String): Producer<String, Any?> {
        logger.info("kafkaProducer.createProducer is running.")
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = DataSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }

    fun produce(brokers: String, topic: String) {
        logger.info("kafkaProducer.produce is running for topic $topic.")
        val producer = createProducer(brokers)
        var futureResult: Future<RecordMetadata>
        when (topic) {
            CUSTOMERS_TOPIC -> {
                futureResult = producer.send(ProducerRecord(CUSTOMERS_TOPIC, DataGenerator.testCustomer))
            }

            ORDERS_TOPIC -> {
                futureResult = producer.send(ProducerRecord(ORDERS_TOPIC, DataGenerator.testOrder))
            }

            INVOICES_TOPIC -> {
                futureResult = producer.send(ProducerRecord(INVOICES_TOPIC, DataGenerator.testInvoice))
            }

            CASES_TOPIC -> {
                futureResult = producer.send(ProducerRecord(CASES_TOPIC, DataGenerator.testCase))
            }

            STATUSES_TOPIC -> {
                futureResult = producer.send(ProducerRecord(STATUSES_TOPIC, DataGenerator.testStatus))
            }

            APPEARANCES_TOPIC -> {
                futureResult = producer.send(ProducerRecord(APPEARANCES_TOPIC, DataGenerator.testAppearance))
            }

            else -> futureResult = producer.send(ProducerRecord(CUSTOMERS_TOPIC, "There is no data to be sent."))
        }
        logger.info("Kafka message from DataGenerator was sent to producer for topic $topic.")
        futureResult.get()
    }
}
