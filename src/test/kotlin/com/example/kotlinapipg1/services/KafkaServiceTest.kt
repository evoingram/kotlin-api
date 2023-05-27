package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.utils.Constants.APPEARANCES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CASES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.INVOICES_TOPIC
import com.example.kotlinapipg1.utils.Constants.ORDERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.STATUSES_TOPIC
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaServiceTest {

    @Test
    fun `test produceMessage produces messages to CUSTOMERS_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(CUSTOMERS_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic $CUSTOMERS_TOPIC were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from CUSTOMERS_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(CUSTOMERS_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on $CUSTOMERS_TOPIC was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to ORDERS_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(ORDERS_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic $ORDERS_TOPIC were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from ORDERS_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(ORDERS_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on $ORDERS_TOPIC was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to INVOICES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(INVOICES_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic $INVOICES_TOPIC were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from INVOICES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(INVOICES_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on $INVOICES_TOPIC was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to CASES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(CASES_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic $CASES_TOPIC were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from CASES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(CASES_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on $CASES_TOPIC was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to STATUSES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(STATUSES_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic $STATUSES_TOPIC were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from STATUSES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(STATUSES_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on $STATUSES_TOPIC was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to APPEARANCES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage(APPEARANCES_TOPIC)
        Assertions.assertEquals(messageProduced, "Kafka message for topic ${APPEARANCES_TOPIC} were sent to producer.")
    }

    @Test
    fun `test consumeMessage consumes messages from APPEARANCES_TOPIC`() {
        val kafkaService = KafkaService()
        val messageConsumed = kafkaService.consumeMessage(APPEARANCES_TOPIC)
        Assertions.assertEquals(messageConsumed, "Kafka message for items on ${APPEARANCES_TOPIC} was consumed.")
    }

    @Test
    fun `test produceMessage produces messages to non-valid topic`() {
        val kafkaService = KafkaService()
        val messageProduced = kafkaService.produceMessage("NO_TOPIC_TOPIC")
        Assertions.assertEquals("Kafka message for topic NO_TOPIC_TOPIC were sent to producer.", messageProduced)
    }
}