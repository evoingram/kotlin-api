package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.Appearance
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

class AppearancesTest {
    private val appearancesId: UUID = randomUUID()
    private val customersId: UUID = randomUUID()
    private val ordersId: UUID = randomUUID()
    private val ordersAppearancesId: UUID = randomUUID()

    private val mockAppearance1 = Appearance(
        appearancesId.toString(),
        customersId.toString(),
        ordersId.toString(),
        ordersAppearancesId.toString()
    )

    private val mockAppearance2 = Appearance(
        appearancesId.toString(),
        customersId.toString(),
        ordersId.toString(),
        ordersAppearancesId.toString()
    )

    @Test
    @DisplayName("test Appearance data class")
    fun `test Appearance data class`() {
        assertEquals(customersId.toString(), mockAppearance1.customersId)
        assertEquals(ordersId.toString(), mockAppearance1.ordersId)
        assertEquals(ordersAppearancesId.toString(), mockAppearance1.ordersAppearancesId)
    }

    @Test
    @DisplayName("test Appearance data class equality")
    fun `test Appearance data class equality`() {
        assertEquals(mockAppearance1, mockAppearance2)
    }
}
