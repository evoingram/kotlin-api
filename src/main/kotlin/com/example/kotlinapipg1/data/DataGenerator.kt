package com.example.kotlinapipg1.data

import com.example.kotlinapipg1.Customer
import com.github.javafaker.Faker
import java.util.*

object DataGenerator {
    private val faker1 = Faker()
    private val faker2 = Faker()
    private val customersId1 = UUID.randomUUID().toString()
    private val usersId1 = UUID.randomUUID().toString()
    private val customersId2 = UUID.randomUUID().toString()
    private val usersId2 = UUID.randomUUID().toString()

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
}
