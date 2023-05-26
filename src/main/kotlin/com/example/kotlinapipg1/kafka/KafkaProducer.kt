package com.example.kotlinapipg1.kafka

import com.example.kotlinapipg1.Appearance
import com.example.kotlinapipg1.Case
import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.Invoice
import com.example.kotlinapipg1.Order
import com.example.kotlinapipg1.Status
import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.utils.Constants.APPEARANCES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CASES_TOPIC
import com.example.kotlinapipg1.utils.Constants.CUSTOMERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.INVOICES_TOPIC
import com.example.kotlinapipg1.utils.Constants.ORDERS_TOPIC
import com.example.kotlinapipg1.utils.Constants.STATUSES_TOPIC
import com.example.kotlinapipg1.utils.DataSerializer
import mu.two.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducer {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    private fun createProducer(brokers: String): Producer<String, Any?> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = DataSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }

    fun serializeCustomer(customer: Customer?) = customer ?: DataGenerator.testCustomer1

    fun produceCustomer(brokers: String, customer: Customer) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(CUSTOMERS_TOPIC, customer))
        logger.info("Kafka message for customer $customer was sent to producer.")
        futureResult.get()
    }

    fun produceOrder(brokers: String, order: Order) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(ORDERS_TOPIC, order))
        logger.info("Kafka message for order $order was sent to producer.")
        futureResult.get()
    }

    fun produceCase(brokers: String, case: Case) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(CASES_TOPIC, case))
        logger.info("Kafka message for case $case was sent to producer.")
        futureResult.get()
    }

    fun produceInvoice(brokers: String, invoice: Invoice) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(INVOICES_TOPIC, invoice))
        logger.info("Kafka message for case $invoice was sent to producer.")
        futureResult.get()
    }

    fun produceAppearances(brokers: String, appearances: List<Appearance>) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(APPEARANCES_TOPIC, appearances))
        logger.info("Kafka message for speakers $appearances was sent to producer.")
        futureResult.get()
    }

    fun produceStatus(brokers: String, status: Status) {
        val producer = createProducer(brokers)
        val futureResult = producer.send(ProducerRecord(STATUSES_TOPIC, status))
        logger.info("Kafka message for customer $status was sent to producer.")
        futureResult.get()
    }
}
