package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.Customer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

class CustomerTest {
    private val customersId: UUID = randomUUID()
    private val usersId: UUID = randomUUID()

    private val mockCustomer1 = Customer(
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
        null,
    )

    private val mockCustomer2 = Customer(
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
        null,
    )

    @Test
    @DisplayName("test Customer data class")
    fun `test Customer data class`() {
        assertEquals(customersId.toString(), mockCustomer1.customersId)
        assertEquals(usersId.toString(), mockCustomer1.usersId)
        assertEquals("Erica", mockCustomer1.firstName)
    }

    @Test
    @DisplayName("test Customer data class equality")
    fun `test Customer data class equality`() {
        assertEquals(mockCustomer1, mockCustomer2)
    }
}
