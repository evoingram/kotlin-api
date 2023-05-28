package com.example.kotlinapipg1.controllers

import com.example.kotlinapipg1.dataClasses.ValidatedAddress
import com.example.kotlinapipg1.services.AddressValidationService
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressValidationController(val addressValidationService: AddressValidationService) {
    @GetMapping("/addresses/validate")
    fun validateAddress(): ValidatedAddress = runBlocking { addressValidationService.validateAddress() }
}
