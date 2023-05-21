package com.example.kotlinapipg1.dataClasses

import com.example.kotlinapipg1.Message
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class MessageTest {
    private val messageId: UUID = UUID.randomUUID()

    private val message1 = Message(
        messageId.toString(),
        "testing messages"
    )

    private val message2 = Message(
        messageId.toString(),
        "testing messages"
    )

    @Test
    @DisplayName("test Message data class")
    fun `test Message data class`() {
        Assertions.assertEquals(messageId.toString(), message1.id)
        Assertions.assertEquals("testing messages", message1.text)
    }

    @Test
    @DisplayName("test Message data class equality")
    fun `test Message data class equality`() {
        Assertions.assertEquals(message1, message2)
    }
}