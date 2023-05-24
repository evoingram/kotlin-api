package com.example.kotlinapipg1.kafka

import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.DataSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducer {
    private fun createProducer(brokers: String): Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = StringSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }

    fun serializeAndProduce(brokers: String) {
        val dataSerializer = DataSerializer()
        val testCustomer1 = DataGenerator.testCustomer1
        val testCustomer2 = DataGenerator.testCustomer2
        val fakeCustomer1 = dataSerializer.jsonMapper().writeValueAsString(testCustomer1)
        val fakeCustomer2 = dataSerializer.jsonMapper().writeValueAsString(testCustomer2)
        val producer = createProducer(brokers)
        val futureResult1 = producer.send(ProducerRecord(CUSTOMERS_TOPIC, fakeCustomer1))
        val futureResult2 = producer.send(ProducerRecord(CUSTOMERS_TOPIC, fakeCustomer2))
        println("Kafka message for customer $fakeCustomer1 was sent to producer.")
        println("Kafka message for customer $fakeCustomer2 was sent to producer.")
        futureResult1.get()
        futureResult2.get()
    }
}
