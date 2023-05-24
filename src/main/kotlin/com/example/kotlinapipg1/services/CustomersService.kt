package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.Customer
import com.example.kotlinapipg1.dataClasses.CustomerRequest
import com.example.kotlinapipg1.repositories.CustomersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomersService(val db: CustomersRepository) {
    fun findCustomers(): List<Customer> = db.findAll().toList()

    fun findCustomerByCustomersId(customersId: String): List<Customer> = db.findByCustomersId(customersId).toList()

    fun save(customer: Customer) {
        db.save(customer)
    }

    fun findAllByCustomersId(customersId: String): MutableIterable<Customer> = db.findAllByCustomersId(customersId)

    fun updateCustomerByCustomersId(customersId: String, customerRequest: CustomerRequest) =
        db.updateCustomerByCustomersId(
            customersId,
            customerRequest.firstName,
            customerRequest.lastName,
            customerRequest.city,
            customerRequest.state,
            customerRequest.postalCode,
            customerRequest.company,
            customerRequest.mrMs,
            customerRequest.jobTitle,
            customerRequest.businessPhone,
            customerRequest.address1,
            customerRequest.address2,
            customerRequest.notes,
        )

    fun deleteByCustomersId(customersId: String) = db.deleteByCustomersId(customersId)

    fun existsByCustomersId(customersId: String) = db.existsByCustomersId(customersId)

    fun findCustomerByPhoneNumber(phoneNumber: String): Customer =
        db.findAll().filter { it.businessPhone == phoneNumber }[0]

    fun findCustomerByCompany(company: String): Customer = db.findAll().filter { it.company == company }[0]

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
