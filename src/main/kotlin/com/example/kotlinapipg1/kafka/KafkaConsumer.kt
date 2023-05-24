package com.example.kotlinapipg1.kafka

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.utils.DataDeserializer
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.util.*

class KafkaConsumer {
    fun createConsumer(brokers: String): Consumer<String, Customer> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["group.id"] = "person-processor"
        props["key.deserializer"] = StringDeserializer::class.java
        props["value.deserializer"] = DataDeserializer::class.java
        return KafkaConsumer(props)
    }
}
