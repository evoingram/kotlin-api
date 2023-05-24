package com.example.kotlinapipg1.dataClasses

data class CustomerRequest(
    var customersId: String?,
    val usersId: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val city: String? = null,
    val state: String? = null,
    val postalCode: String? = null,
    val company: String? = null,
    val mrMs: String? = null,
    val jobTitle: String? = null,
    val businessPhone: String? = null,
    val address1: String? = null,
    val address2: String? = null,
    val notes: String? = null,
)
