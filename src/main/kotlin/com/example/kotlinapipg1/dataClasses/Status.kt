package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("STATUSES")
data class Status(
    @Id var statusesId: String,
    val status: StatusType
)

enum class StatusType { NEED_INFO, NEED_PAYMENT, IN_PROGRESS, READY_FOR_FILING, FILED, COMPLETE }