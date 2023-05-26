package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

@Table("INVOICES")
data class Invoice(
    @Id var invoicesId: String,
    val invoiceDate: OffsetDateTime,
    val customersId: String,
    val casesId: String,
    val paid: Boolean,
    val factored: Boolean
)
