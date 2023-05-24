package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.kafka.KafkaConsumer
import com.example.kotlinapipg1.kafka.KafkaProducer
import com.example.kotlinapipg1.repositories.KafkaRepository
import com.example.kotlinapipg1.utils.Constants.BROKER_ADDRESS
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.DataSerializer
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class KafkaService : KafkaRepository {

    val kafkaProducer = KafkaProducer()
    val kafkaConsumer = KafkaConsumer().createConsumer(
        BROKER_ADDRESS,
    )

    override fun produceCustomersMessage(): String {
        kafkaProducer.serializeAndProduce(BROKER_ADDRESS)
        consumeCustomersMessage()
        return "Kafka message for customers were sent to producer."
    }

    override fun consumeCustomersMessage(): String {
        kafkaConsumer.subscribe(listOf(CUSTOMERS_TOPIC))
        println("Kafka message consumed for customer1 & customer2")
        keepRecords()
        return "Kafka message for customers was consumed."
    }

    override fun keepRecords() {
        println("keepRecords is running")
        val dataSerializer = DataSerializer()
        val records = kafkaConsumer.poll(Duration.ofSeconds(1))
        println("$records = number of records")
        records.forEach { customer ->
            val customerJson = customer.value()
            println("customer JSON = $customerJson")

            val customerPerson = dataSerializer.jsonMapper().readValue(customerJson, Customer::class.java)
            println("customerPerson = $customerPerson")
        }
    }
}
