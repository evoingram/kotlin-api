package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Message
import com.example.kotlinapipg1.repositories.MessageRepository
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class MessageServiceTest {

    @Mock
    private lateinit var messagesRepository: MessageRepository

    private final val messagesId = UUID.randomUUID().toString()
    val testMessage1 = Message(messagesId, "John Doe")
    val testMessage2 = Message(messagesId, "buttercup")

    @Test
    fun `test delete message by messages id`() {
        `when`(messagesRepository.findById(messagesId)).thenReturn(Optional.of(testMessage1))
        val messageService = MessageService(messagesRepository)
        messageService.deleteById(messagesId)
        verify(messagesRepository).deleteById(messagesId)
    }

    @Test
    fun `test exists by messages id`() {
        `when`(messagesRepository.findById(messagesId)).thenReturn(Optional.empty())
        val messageService = MessageService(messagesRepository)
        messageService.existsById(messagesId)
        verify(messagesRepository).existsById(messagesId)
    }

    @Test
    fun `test find message by id`() {
        `when`(messagesRepository.findById(testMessage2.id.toString())).thenReturn(Optional.of(testMessage2))
        val messageService = MessageService(messagesRepository)
        messageService.findMessageById(testMessage2.id.toString())
        verify(messagesRepository).findById(testMessage2.id.toString())
    }

    @Test
    fun `test find messages`() {
        `when`(messagesRepository.findAll()).thenReturn(listOf(testMessage2))
        val messageService = MessageService(messagesRepository)
        messageService.findMessages()
        verify(messagesRepository).findAll()
    }
}
