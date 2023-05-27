package com.example.kotlinapipg1.impls

import com.example.kotlinapipg1.services.KafkaService
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaRepositoryImplTest {

    @Mock
    lateinit var kafkaService: KafkaService

    @Test
    fun `test producing messages`() {
        val kafkaRepositoryImpl = KafkaRepositoryImpl()
        val expected = "Kafka message for topic $CUSTOMERS_TOPIC were sent to producer."
        `when`(kafkaService.produceMessage(CUSTOMERS_TOPIC)).thenReturn(expected)
        val response = kafkaRepositoryImpl.produceMessage(CUSTOMERS_TOPIC)
        assertEquals(expected, response)
    }

    @Test
    fun `test consuming messages`() {
        val kafkaRepositoryImpl = KafkaRepositoryImpl()
        val expected = "Kafka message for items on $CUSTOMERS_TOPIC was consumed."
        `when`(kafkaService.consumeMessage(CUSTOMERS_TOPIC)).thenReturn(expected)
        val response = kafkaRepositoryImpl.consumeMessage(CUSTOMERS_TOPIC)
        assertEquals(expected, response)
    }
}
