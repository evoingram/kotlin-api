package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.Customer
import org.springframework.data.repository.CrudRepository

interface CustomersRepository : CrudRepository<Customer, String> {
    fun findAllById(id: String): MutableIterable<Customer>
}
