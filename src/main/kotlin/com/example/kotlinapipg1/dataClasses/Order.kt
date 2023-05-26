package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

@Table("ORDERS")
data class Order(
    @Id var ordersId: String?,
    val turnaround: Turnaround,
    val audioLength: Int,
    val orderDate: OffsetDateTime,
    val filed: Boolean? = false,
    val casesId: String? = null,
    val invoicesId: String? = null,
    val customersId: String? = null,
)

enum class Turnaround(val days: Int) {
    One(1),
    Seven(7),
    Fourteen(14),
    Thirty(30),
    FortyFive(45)
}