package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.services.KafkaService
import com.example.kotlinapipg1.utils.Constants.APPEARANCES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CASES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.INVOICES_TOPIC
import com.example.kotlinapipg1.utils.Constants.ORDERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.STATUSES_TOPIC
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaControllerTest {

    @Mock
    lateinit var kafkaService: KafkaService

    @Test
    fun `test GET messages slash send slash customers`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $CUSTOMERS_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(CUSTOMERS_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceCustomerMessages()
        verify(kafkaService).produceMessage(CUSTOMERS_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash customers`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on $CUSTOMERS_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(CUSTOMERS_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeCustomerMessages()
        verify(kafkaService).consumeMessage(CUSTOMERS_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash send slash orders`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $ORDERS_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(ORDERS_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceOrderMessages()
        verify(kafkaService).produceMessage(ORDERS_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash orders`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on ${ORDERS_TOPIC} was consumed."
        `when`(kafkaService.consumeMessage(ORDERS_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeOrderMessages()
        verify(kafkaService).consumeMessage(ORDERS_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash send slash cases`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $CASES_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(CASES_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceCasesMessages()
        verify(kafkaService).produceMessage(CASES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash cases`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on $CASES_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(CASES_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeCasesMessages()
        verify(kafkaService).consumeMessage(CASES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash send slash invoices`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $INVOICES_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(INVOICES_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceInvoicesMessages()
        verify(kafkaService).produceMessage(INVOICES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash invoices`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on $INVOICES_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(INVOICES_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeInvoicesMessages()
        verify(kafkaService).consumeMessage(INVOICES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash send slash statuses`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $STATUSES_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(STATUSES_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceStatusMessages()
        verify(kafkaService).produceMessage(STATUSES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash statuses`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on $STATUSES_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(STATUSES_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeStatusMessages()
        verify(kafkaService).consumeMessage(STATUSES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash send slash appearances`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for topic $APPEARANCES_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(APPEARANCES_TOPIC)).thenReturn(expected)
        val response = kafkaController.produceAppearancesMessages()
        verify(kafkaService).produceMessage(APPEARANCES_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test GET messages slash receive slash appearances`() {
        val kafkaController = KafkaController(kafkaService)
        val expected = "Kafka message for items on $APPEARANCES_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(APPEARANCES_TOPIC)).thenReturn(expected)
        val response = kafkaController.consumeAppearancesMessages()
        verify(kafkaService).consumeMessage(APPEARANCES_TOPIC)
        assertEquals(expected, response)
    }
}
