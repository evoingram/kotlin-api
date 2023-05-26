package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("APPEARANCES")
data class Appearance(
    @Id var appearancesId: String,
    val customersId: String,
    val ordersId: String,
    val ordersAppearancesId: String
)
