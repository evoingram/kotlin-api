package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("CUSTOMERS")
data class Customer(
    @Id var customersId: String?,
    val usersId: String,
    val firstName: String,
    val lastName: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val company: String? = null,
    val mrms: String? = null,
    val jobTitle: String? = null,
    val businessPhone: String? = null,
    val address1: String? = null,
    val address2: String? = null,
    val notes: String? = null
)
