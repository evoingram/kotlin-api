package com.example.kotlinapipg1.dataClasses

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

class CustomerRequestTest {
    private val customersId: UUID = randomUUID()
    private val usersId: UUID = randomUUID()

    private val mockCustomerRequest1 = CustomerRequest(
        customersId.toString(),
        usersId.toString(),
        "Erica",
        "Ingram",
        "Seattle",
        "WA",
        "98119",
        "A Quo Co.",
        "Ms",
        "Owner",
        "1234567890",
        "123 Anywhere Street",
        null,
        null
    )

    private val mockCustomerRequest2 = CustomerRequest(
        customersId.toString(),
        usersId.toString(),
        "Erica",
        "Ingram",
        "Seattle",
        "WA",
        "98119",
        "A Quo Co.",
        "Ms",
        "Owner",
        "1234567890",
        "123 Anywhere Street",
        null,
        null
    )

    @Test
    @DisplayName("test CustomerRequest data class")
    fun `test CustomerRequest data class`() {
        Assertions.assertEquals(customersId.toString(), mockCustomerRequest1.customersId)
        Assertions.assertEquals(usersId.toString(), mockCustomerRequest1.usersId)
        Assertions.assertEquals("Erica", mockCustomerRequest1.firstName)
    }

    @Test
    @DisplayName("test CustomerRequest data class equality")
    fun `test CustomerRequest data class equality`() {
        Assertions.assertEquals(mockCustomerRequest1, mockCustomerRequest2)
    }
}