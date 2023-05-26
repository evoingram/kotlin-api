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
    private val faker2 = Faker()
    private val customersId1 = generateId()
    private val usersId1 = generateId()
    private val customersId2 = generateId()
    private val usersId2 = generateId()
    private val casesId = generateId()
    private val appearancesId = generateId()
    private val ordersId = generateId()
    private val invoicesId = generateId()
    private val ordersAppearancesId = generateId()
    private val statusesId = generateId()


    val testCustomer1 = Customer(
        customersId1,
        usersId1,
        faker1.name().firstName(),
        faker1.name().lastName(),
        faker1.address().city(),
        faker1.address().state(),
        faker1.address().zipCode(),
        faker1.company().toString(),
    )

    val testCustomer2 = Customer(
        customersId2,
        usersId2,
        faker2.name().firstName(),
        faker2.name().lastName(),
        faker2.address().city(),
        faker2.address().state(),
        faker2.address().zipCode(),
        faker2.company().toString(),
        businessPhone = faker2.phoneNumber().toString(),
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
        OffsetDateTime.now(),
        customersId1,
        casesId,
        paid = false,
        factored = false
    )

    val testOrder = Order(
        ordersId,
        Turnaround.FortyFive,
        60,
        OffsetDateTime.now(),
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
