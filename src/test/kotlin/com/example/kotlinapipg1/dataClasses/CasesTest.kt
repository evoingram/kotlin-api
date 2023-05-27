package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.Case
import com.example.kotlinapipg1.data.DataGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

class CasesTest {
    private val casesId: UUID = randomUUID()

    private val mockCase1 = Case(
        casesId.toString(),
        DataGenerator.testCase.party1,
        DataGenerator.testCase.party1Type,
        DataGenerator.testCase.party2,
        DataGenerator.testCase.party2Type,
        DataGenerator.testCase.caseNumber1,
        DataGenerator.testCase.caseNumber2,
        DataGenerator.testCase.jurisdiction,
        DataGenerator.testCase.notes
    )

    private val mockCase2 = Case(
        casesId.toString(),
        DataGenerator.testCase.party1,
        DataGenerator.testCase.party1Type,
        DataGenerator.testCase.party2,
        DataGenerator.testCase.party2Type,
        DataGenerator.testCase.caseNumber1,
        DataGenerator.testCase.caseNumber2,
        DataGenerator.testCase.jurisdiction,
        DataGenerator.testCase.notes
    )

    @Test
    @DisplayName("test Case data class")
    fun `test Case data class`() {
        assertEquals(casesId.toString(), mockCase1.casesId)
        assertEquals(DataGenerator.testCase.party1, mockCase1.party1)
        assertEquals(DataGenerator.testCase.party2, mockCase1.party2)
    }

    @Test
    @DisplayName("test Case data class equality")
    fun `test Case data class equality`() {
        assertEquals(mockCase1, mockCase2)
    }
}
