package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.services.CustomersService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomersController(val customersService: CustomersService) {
    @GetMapping("/customers")
    fun index(): List<Customer> = customersService.findCustomers()

    @GetMapping("/customers/{id}")
    fun findCustomerById(@PathVariable id: String) = customersService.findCustomerById(id)

    @GetMapping("/customers/{id}/all")
    fun findAllById(@PathVariable id: String) = customersService.findAllById(id)

    @GetMapping("/customers/{id}/exists")
    fun existsById(@PathVariable id: String) = customersService.existsById(id)

    @GetMapping("/customers/phoneNumber/{phoneNumber}")
    fun findCustomerByPhoneNumber(@PathVariable phoneNumber: String): Customer =
        customersService.findCustomerByPhoneNumber(phoneNumber)

    @GetMapping("/customers/company/{company}")
    fun findCustomerByCompany(@PathVariable company: String): Customer = customersService.findCustomerByCompany(company)

    @DeleteMapping("/customers/{id}")
    fun deleteById(@PathVariable id: String) = customersService.deleteById(id)

    @PostMapping("/customers")
    fun post(@RequestBody customer: Customer) = customersService.save(customer)
}
