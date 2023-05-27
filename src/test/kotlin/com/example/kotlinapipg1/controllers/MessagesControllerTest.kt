package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Message
import com.example.kotlinapipg1.services.MessageService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class MessageControllerTest {

    @Mock
    lateinit var messagesService: MessageService

    private final val messagesId1 = UUID.randomUUID().toString()

    val testMessage = Message(
        messagesId1,
        "buttercup"
    )

    @Test
    fun `test GET messages`() {
        val messageController = MessageController(messagesService)
        val expected = mutableListOf(testMessage)
        `when`(messagesService.findMessages()).thenReturn(expected)
        val response = messageController.index()
        verify(messagesService).findMessages()
        assertEquals(response, expected)
    }

    @Test
    fun `test GET messages slash {messagesId}`() {
        val messageController = MessageController(messagesService)
        val expected = mutableListOf(testMessage)
        `when`(messagesService.findAllById(messagesId1)).thenReturn(expected)
        val response = messageController.findAllById(messagesId1)
        verify(messagesService).findAllById(messagesId1)
        assertEquals(response, expected)
    }

    @Test
    fun `test GET messages slash {messagesId} slash exists`() {
        val messageController = MessageController(messagesService)
        `when`(messagesService.existsById(messagesId1)).thenReturn(true)
        val response = messageController.existsById(messagesId1)
        verify(messagesService).existsById(messagesId1)
        assertEquals(response, true)
    }


    @Test
    fun `test DELETE messages slash {messagesId}`() {
        val messageController = MessageController(messagesService)
        val response = messageController.deleteById(messagesId1)
        verify(messagesService).deleteById(messagesId1)
        assertEquals(response, Unit)
    }


    @Test
    fun `test POST messages slash {messagesId}`() {
        val messageController = MessageController(messagesService)
        doNothing().`when`(messagesService).save(testMessage)
        val response = messageController.post(testMessage)
        verify(messagesService).save(testMessage)
        assertEquals(response, Unit)
    }
}
