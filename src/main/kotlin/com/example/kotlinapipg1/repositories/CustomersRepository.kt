package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.Customer
import org.springframework.data.repository.CrudRepository

interface CustomersRepository : CrudRepository<Customer, String> {
    fun findAllByCustomersId(customersId: String): MutableIterable<Customer>

    fun findByCustomersId(customersId: String): List<Customer>

    fun deleteByCustomersId(customersId: String)

    fun updateCustomerByCustomersId(customersId: String)

    fun existsByCustomersId(customersId: String)
}
