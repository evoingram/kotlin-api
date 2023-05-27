package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.services.KafkaService
import com.example.kotlinapipg1.utils.Constants.APPEARANCES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CASES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.INVOICES_TOPIC
import com.example.kotlinapipg1.utils.Constants.ORDERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.STATUSES_TOPIC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(val kafkaService: KafkaService) {
    @GetMapping("/messages/send/customers")
    fun produceCustomerMessages(): String = kafkaService.produceMessage(CUSTOMERS_TOPIC)

    @GetMapping("/messages/receive/customers")
    fun consumeCustomerMessages(): String = kafkaService.consumeMessage(CUSTOMERS_TOPIC)

    @GetMapping("/messages/send/orders")
    fun produceOrderMessages(): String = kafkaService.produceMessage(ORDERS_TOPIC)

    @GetMapping("/messages/receive/orders")
    fun consumeOrderMessages(): String = kafkaService.consumeMessage(ORDERS_TOPIC)

    @GetMapping("/messages/send/cases")
    fun produceCasesMessages(): String = kafkaService.produceMessage(CASES_TOPIC)

    @GetMapping("/messages/receive/cases")
    fun consumeCasesMessages(): String = kafkaService.consumeMessage(CASES_TOPIC)

    @GetMapping("/messages/send/invoices")
    fun produceInvoicesMessages(): String = kafkaService.produceMessage(INVOICES_TOPIC)

    @GetMapping("/messages/receive/invoices")
    fun consumeInvoicesMessages(): String = kafkaService.consumeMessage(INVOICES_TOPIC)

    @GetMapping("/messages/send/status")
    fun produceStatusMessages(): String = kafkaService.produceMessage(STATUSES_TOPIC)

    @GetMapping("/messages/receive/status")
    fun consumeStatusMessages(): String = kafkaService.consumeMessage(STATUSES_TOPIC)

    @GetMapping("/messages/send/appearances")
    fun produceAppearancesMessages(): String = kafkaService.produceMessage(APPEARANCES_TOPIC)

    @GetMapping("/messages/receive/appearances")
    fun consumeAppearancesMessages(): String = kafkaService.consumeMessage(APPEARANCES_TOPIC)
}
