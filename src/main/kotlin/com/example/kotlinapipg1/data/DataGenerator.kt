package com.example.kotlinapipg1.data

import com.example.kotlinapipg1.Appearance
import com.example.kotlinapipg1.Case
import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.Invoice
import com.example.kotlinapipg1.Jurisdiction
import com.example.kotlinapipg1.Order
import com.example.kotlinapipg1.Party1Type
import com.example.kotlinapipg1.Party2Type
import com.example.kotlinapipg1.Status
import com.example.kotlinapipg1.StatusType
import com.example.kotlinapipg1.Turnaround
import com.github.javafaker.Faker
import java.time.OffsetDateTime
import java.util.*

object DataGenerator {
    private val faker1 = Faker()
    private val customersId1 = generateId()
    private val usersId1 = generateId()
    private val casesId = generateId()
    private val appearancesId = generateId()
    private val ordersId = generateId()
    private val invoicesId = generateId()
    private val ordersAppearancesId = generateId()
    private val statusesId = generateId()


    val testCustomer = Customer(
        customersId1,
        usersId1,
        faker1.name().firstName(),
        faker1.name().lastName(),
        faker1.address().city(),
        faker1.address().state(),
        faker1.address().zipCode(),
        faker1.company().toString(),
    )

    val testAppearance = Appearance(
        appearancesId,
        customersId1,
        ordersId,
        ordersAppearancesId
    )

    val testCase = Case(
        casesId,
        "Party 1 Testing",
        Party1Type.PLAINTIFF,
        "Party 2 Testing",
        Party2Type.DEFENDANT,
        "case-number-1",
        "case-number-2",
        Jurisdiction.KING_COUNTY,
        "notes testing"
    )

    val testInvoice = Invoice(
        generateId(),
        OffsetDateTime.now().toString(),
        customersId1,
        casesId,
        paid = false,
        factored = false
    )

    val testOrder = Order(
        ordersId,
        Turnaround.FortyFive.days,
        60,
        OffsetDateTime.now().toString(),
        false,
        casesId,
        invoicesId,
        customersId1
    )

    val testStatus = Status(
        statusesId,
        StatusType.NEED_PAYMENT
    )

    private fun generateId() = UUID.randomUUID().toString()
}
