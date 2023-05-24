package com.example.kotlinapipg1.kafka

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.DataSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducer {
    private fun createProducer(brokers: String): Producer<String, Customer> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = DataSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }

    fun serializeAndProduce(brokers: String) {
        val testCustomer1 = DataGenerator.testCustomer1
        val testCustomer2 = DataGenerator.testCustomer2
        val producer = createProducer(brokers)
        val futureResult1 = producer.send(ProducerRecord(CUSTOMERS_TOPIC, testCustomer1))
        val futureResult2 = producer.send(ProducerRecord(CUSTOMERS_TOPIC, testCustomer2))
        println("Kafka message for customer $testCustomer1 was sent to producer.")
        println("Kafka message for customer $testCustomer2 was sent to producer.")
        futureResult1.get()
        futureResult2.get()
    }
}
