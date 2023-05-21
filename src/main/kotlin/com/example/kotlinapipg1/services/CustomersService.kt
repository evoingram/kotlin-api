package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.repositories.CustomersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomersService(val db: CustomersRepository) {
    fun findCustomers(): List<Customer> = db.findAll().toList()

    fun findCustomerById(id: String): List<Customer> = db.findById(id).toList()

    fun save(customer: Customer) {
        db.save(customer)
    }

    fun findAllById(id: String): MutableIterable<Customer> = db.findAllById(id)

    fun deleteById(id: String) = db.deleteById(id)

    fun existsById(id: String) = db.existsById(id)

    fun findCustomerByPhoneNumber(phoneNumber: String): Customer =
        db.findAll().filter { it.businessPhone == phoneNumber }[0]

    fun findCustomerByCompany(company: String): Customer = db.findAll().filter { it.company == company }[0]

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
