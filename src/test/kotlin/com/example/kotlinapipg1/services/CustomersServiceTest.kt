package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.data.DataGenerator
import com.example.kotlinapipg1.dataClasses.CustomerRequest
import com.example.kotlinapipg1.repositories.CustomersRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ExtendWith(MockitoExtension::class)
class CustomersServiceTest {

    @Mock
    lateinit var customersRepository: CustomersRepository

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
        val customerService = CustomersService(customersRepository)
        customerService.deleteByCustomersId(customersId1)
        verify(customersRepository).deleteByCustomersId(customersId1)
    }

    @Test
    fun `test exists by customers id`() {
        val customerService = CustomersService(customersRepository)
        customerService.existsByCustomersId(customersId1)
        verify(customersRepository).existsByCustomersId(customersId1)
    }

    @Test
    fun `test find customer by company`() {
        val customerService = CustomersService(customersRepository)
        `when`(customersRepository.findAll()).thenReturn(listOf(testCustomer2))
        customerService.findCustomerByCompany(testCustomer2.company.toString())
        verify(customersRepository).findAll()
    }

    @Test
    fun `test find customer by phone number`() {
        val customerService = CustomersService(customersRepository)
        `when`(customersRepository.findAll()).thenReturn(listOf(testCustomer2))
        customerService.findCustomerByPhoneNumber(testCustomer2.businessPhone.toString())
        verify(customersRepository).findAll()
    }

    @Test
    fun `test find customers`() {
        val customerService = CustomersService(customersRepository)
        `when`(customersRepository.findAll()).thenReturn(listOf(testCustomer2))
        customerService.findCustomers()
        verify(customersRepository).findAll()
    }

    @Test
    fun `test find customers by customers id`() {
        val customerService = CustomersService(customersRepository)
        `when`(customersRepository.findByCustomersId(customersId1)).thenReturn(listOf(testCustomer))
        customerService.findCustomerByCustomersId(customersId1)
        verify(customersRepository).findByCustomersId(customersId1)
    }

    @Test
    fun `test find all by customers id`() {
        val customerService = CustomersService(customersRepository)
        `when`(customersRepository.findAllByCustomersId(customersId1)).thenReturn(mutableListOf(testCustomer))
        customerService.findAllByCustomersId(customersId1)
        verify(customersRepository).findAllByCustomersId(customersId1)
    }

    @Test
    fun `test saving customer to database`() {
        val customerService = CustomersService(customersRepository)
        val customer = DataGenerator.testCustomer
        `when`(customersRepository.save(customer)).thenReturn(customer)
        val savedCustomer = customerService.save(customer)
        assertEquals(customer, savedCustomer)
        verify(customersRepository).save(customer)
    }

    @Test
    fun `test updating customer`() {
        val customerService = CustomersService(customersRepository)
        Mockito.doNothing().`when`(customersRepository)
            .updateCustomerByCustomersId(testCustomer.customersId.toString(), "Adam", "Ingramm")
        customerService.updateCustomerByCustomersId(
            testCustomer.customersId.toString(),
            CustomerRequest(testCustomer.customersId.toString(), firstName = "Adam", lastName = "Ingramm")
        )
        verify(customersRepository).updateCustomerByCustomersId(testCustomer.customersId.toString(), "Adam", "Ingramm")
    }
}
