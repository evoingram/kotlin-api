package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.services.CustomersService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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

    @PutMapping("/customers/{customersId}")
    fun updateByCustomersId(@PathVariable customersId: String) = customersService.deleteByCustomersId(customersId)

    @DeleteMapping("/customers/{customersId}")
    fun deleteByCustomersId(@PathVariable customersId: String) = customersService.deleteByCustomersId(customersId)

    @PostMapping("/customers")
    fun post(@RequestBody customer: Customer) = customersService.save(customer)
}
