package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.dataClasses.ValidatedAddress

interface AddressValidationRepository {
    suspend fun validateAddress(): ValidatedAddress
}
