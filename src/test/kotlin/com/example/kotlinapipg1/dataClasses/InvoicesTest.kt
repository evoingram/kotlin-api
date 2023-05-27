package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.Invoice
import com.example.kotlinapipg1.data.DataGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

class InvoicesTest {
    private val invoicesId: UUID = randomUUID()

    private val mockInvoice1 = Invoice(
        invoicesId.toString(),
        DataGenerator.testInvoice.invoiceDate,
        DataGenerator.testInvoice.customersId,
        DataGenerator.testInvoice.casesId,
        DataGenerator.testInvoice.paid,
        DataGenerator.testInvoice.factored
    )

    private val mockInvoice2 = Invoice(
        invoicesId.toString(),
        DataGenerator.testInvoice.invoiceDate,
        DataGenerator.testInvoice.customersId,
        DataGenerator.testInvoice.casesId,
        DataGenerator.testInvoice.paid,
        DataGenerator.testInvoice.factored
    )

    @Test
    @DisplayName("test Invoice data class")
    fun `test Invoice data class`() {
        assertEquals(invoicesId.toString(), mockInvoice1.invoicesId)
        assertEquals(DataGenerator.testInvoice.invoiceDate, mockInvoice1.invoiceDate)
        assertEquals(DataGenerator.testInvoice.paid, mockInvoice1.paid)
    }

    @Test
    @DisplayName("test Invoice data class equality")
    fun `test Invoice data class equality`() {
        assertEquals(mockInvoice1, mockInvoice2)
    }
}
