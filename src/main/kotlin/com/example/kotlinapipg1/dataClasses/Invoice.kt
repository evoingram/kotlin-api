package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("INVOICES")
data class Invoice(
    @Id var invoicesId: String,
    val invoiceDate: String,
    val customersId: String,
    val casesId: String,
    val paid: Boolean,
    val factored: Boolean
)
