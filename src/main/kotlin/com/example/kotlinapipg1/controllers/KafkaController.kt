package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.services.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(val kafkaService: KafkaService) {
    @GetMapping("/messages/send")
    fun produceCustomersMessages(): String = kafkaService.produceCustomersMessage()
}
