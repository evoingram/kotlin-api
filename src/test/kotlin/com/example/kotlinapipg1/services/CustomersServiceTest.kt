package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.repositories.CustomersRepository
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class CustomersServiceTest {

    @Mock
    private lateinit var customersRepository: CustomersRepository

    private final val usersId1 = UUID.randomUUID().toString()
    private final val usersId2 = UUID.randomUUID().toString()
    private final val customersId1 = UUID.randomUUID().toString()
    private final val customersId2 = UUID.randomUUID().toString()

    val testCustomer = Customer(
        customersId1,
        usersId1,
        "Erica",
        "Ingram",
        "Seattle",
        "WA",
        "98119",
        "ABC",
    )

    val testCustomer2 = Customer(
        customersId2,
        usersId2,
        "ADAM",
        "Ingram",
        "Seattle",
        "WA",
        "98119",
        "E2W",
        businessPhone = "2061234567",
    )

    @Test
    fun `test delete customer by customers id`() {
        `when`(customersRepository.findById(customersId1)).thenReturn(Optional.of(testCustomer))
        val customerService = CustomersService(customersRepository)
        customerService.deleteByCustomersId(customersId1)
        verify(customersRepository).deleteByCustomersId(customersId1)
    }

    @Test
    fun `test exists by customers id`() {
        `when`(customersRepository.findById(customersId1)).thenReturn(Optional.empty())
        val customerService = CustomersService(customersRepository)
        customerService.existsByCustomersId(customersId1)
        verify(customersRepository).existsByCustomersId(customersId1)
    }

    @Test
    fun `test find customer by company`() {
        `when`(customersRepository.findAll()).thenReturn(listOf(testCustomer2))
        val customerService = CustomersService(customersRepository)
        customerService.findCustomerByCompany(testCustomer2.company.toString())
        verify(customersRepository).findAll()
    }

    @Test
    fun `test find customer by phone number`() {
        `when`(customersRepository.findAll()).thenReturn(listOf(testCustomer2))
        val customerService = CustomersService(customersRepository)
        customerService.findCustomerByPhoneNumber(testCustomer2.businessPhone.toString())
        verify(customersRepository).findAll()
    }

    /*
    @Test
    fun `test exists customer by customersId -- null customer throws IllegalArgumentException`() {
        `when`(customersRepository.findById(customersId)).thenReturn(Optional.empty())
        val customerService = CustomersService(customersRepository)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            customerService.existsByCustomersId(null)
        }
        assertEquals("Customer not found", exception.message)
    }

    @Test
    fun `test delete customer by customersId -- customer not found`() {
        `when`(customersRepository.findById(customersId)).thenReturn(Optional.empty())
        val customerService = CustomersService(customersRepository)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            customerService.deleteByCustomersId(customersId)
        }
        assertEquals("Customer not found", exception.message)
    }

     */
}
