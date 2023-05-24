package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.dataClasses.CustomerRequest
import com.example.kotlinapipg1.services.CustomersService
import org.springframework.web.bind.annotation.*

@RestController
class CustomersController(val customersService: CustomersService) {
    @GetMapping("/customers")
    fun index(): List<Customer> = customersService.findCustomers()

    @GetMapping("/customers/{customersId}")
    fun findCustomerByCustomersId(@PathVariable customersId: String) =
        customersService.findCustomerByCustomersId(customersId)

    @GetMapping("/customers/{customersId}/all")
    fun findAllByCustomersId(@PathVariable customersId: String) = customersService.findAllByCustomersId(customersId)

    @GetMapping("/customers/{customersId}/exists")
    fun existsByCustomersId(@PathVariable customersId: String) = customersService.existsByCustomersId(customersId)

    @GetMapping("/customers/phoneNumber/{phoneNumber}")
    fun findCustomerByPhoneNumber(@PathVariable phoneNumber: String): Customer =
        customersService.findCustomerByPhoneNumber(phoneNumber)

    @GetMapping("/customers/company/{company}")
    fun findCustomerByCompany(@PathVariable company: String): Customer = customersService.findCustomerByCompany(company)

    @PutMapping("/users/{customersId}")
    fun updateCustomererByCustomersId(
        @PathVariable customersId: String,
        @RequestBody customerRequest: CustomerRequest,
    ): String {
        val rowsUpdated = customersService.updateCustomerByCustomersId(customersId, customerRequest)
        return "Updated $rowsUpdated customer(s)"
    }

    @DeleteMapping("/customers/{customersId}")
    fun deleteByCustomersId(@PathVariable customersId: String) = customersService.deleteByCustomersId(customersId)

    @PostMapping("/customers")
    fun post(@RequestBody customer: Customer) = customersService.save(customer)
}
