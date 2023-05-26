package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.services.KafkaService
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(val kafkaService: KafkaService) {

    val customer = DataGenerator.testCustomer1

    @GetMapping("/messages/send")
    fun produceMessages(): String = kafkaService.produceMessage(CUSTOMERS_TOPIC)

    @GetMapping("/messages/receive")
    fun consumeMessages(): String = kafkaService.consumeMessage(CUSTOMERS_TOPIC)
}
