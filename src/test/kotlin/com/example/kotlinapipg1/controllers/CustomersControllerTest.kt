package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.dataClasses.CustomerRequest
import com.example.kotlinapipg1.services.CustomersService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class CustomersControllerTest {

    @Mock
    lateinit var customersService: CustomersService

    private final val usersId1 = UUID.randomUUID().toString()
    private final val customersId1 = UUID.randomUUID().toString()

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

    @Test
    fun `test GET customers`() {
        val customerController = CustomersController(customersService)
        val expected = mutableListOf(testCustomer)
        `when`(customersService.findCustomers()).thenReturn(expected)
        val response = customerController.index()
        verify(customersService).findCustomers()
        assertEquals(response, expected)
    }

    @Test
    fun `test GET customers slash {customersId}`() {
        val customerController = CustomersController(customersService)
        val expected = mutableListOf(testCustomer)
        `when`(customersService.findCustomerByCustomersId(customersId1)).thenReturn(expected)
        val response = customerController.findCustomerByCustomersId(customersId1)
        verify(customersService).findCustomerByCustomersId(customersId1)
        assertEquals(response, expected)
    }

    @Test
    fun `test GET customers slash {customersId} slash all`() {
        val customerController = CustomersController(customersService)
        val expected = mutableListOf(testCustomer)
        `when`(customersService.findAllByCustomersId(customersId1)).thenReturn(expected)
        val response = customerController.findAllByCustomersId(customersId1)
        verify(customersService).findAllByCustomersId(customersId1)
        assertEquals(response, expected)
    }

    @Test
    fun `test GET customers slash {customersId} slash exists`() {
        val customerController = CustomersController(customersService)
        doNothing().`when`(customersService).existsByCustomersId(customersId1)
        val response = customerController.existsByCustomersId(customersId1)
        verify(customersService).existsByCustomersId(customersId1)
        assertEquals(response, Unit)
    }

    @Test
    fun `test GET customers slash phoneNumber slash {phoneNumber}`() {
        val customerController = CustomersController(customersService)
        `when`(customersService.findCustomerByPhoneNumber(customersId1)).thenReturn(testCustomer)
        val response = customerController.findCustomerByPhoneNumber(customersId1)
        verify(customersService).findCustomerByPhoneNumber(customersId1)
        assertEquals(response, testCustomer)
    }

    @Test
    fun `test GET customers slash company slash {company}`() {
        val customerController = CustomersController(customersService)
        `when`(customersService.findCustomerByCompany(customersId1)).thenReturn(testCustomer)
        customerController.findCustomerByCompany(customersId1)
        verify(customersService).findCustomerByCompany(customersId1)
    }

    @Test
    fun `test PUT customers slash {customersId}`() {
        val customerController = CustomersController(customersService)
        val customerRequest =
            CustomerRequest(testCustomer.customersId.toString(), firstName = "Adam", lastName = "Ingramm")
        doNothing().`when`(customersService)
            .updateCustomerByCustomersId(testCustomer.customersId.toString(), customerRequest)
        customerController.updateCustomerByCustomersId(testCustomer.customersId.toString(), customerRequest)
        verify(customersService).updateCustomerByCustomersId(testCustomer.customersId.toString(), customerRequest)
    }

    @Test
    fun `test DELETE customers slash {customersId}`() {
        val customerController = CustomersController(customersService)
        val response = customerController.deleteByCustomersId(customersId1)
        verify(customersService).deleteByCustomersId(customersId1)
        assertEquals(response, Unit)
    }


    @Test
    fun `test POST customers slash {customersId}`() {
        val customerController = CustomersController(customersService)
        `when`(customersService.save(testCustomer)).thenReturn(testCustomer)
        val response = customerController.post(testCustomer)
        verify(customersService).save(testCustomer)
        assertEquals(response, testCustomer)
    }
}
