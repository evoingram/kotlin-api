package com.example.kotlinapipg1.repositories

import com.example.kotlinapipg1.Customer
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface CustomersRepository : CrudRepository<Customer, String> {
    fun findAllByCustomersId(customersId: String): MutableIterable<Customer>

    fun findByCustomersId(customersId: String): List<Customer>

    @Modifying
    @Query(
        "UPDATE customers " +
            "SET firstName = :first_name, " +
            "lastName = :last_name, " +
            "city = :city, state = :state, postalCode = :postal_code,  " +
            "company = :company, mrMs = :mr_ms, jobTitle = :job_title, " +
            "businessPhone = :business_phone, address1 = :address1, address2 = :address2, " +
            "notes = :notes " +
            "WHERE customersId = :customersId",
    )
    fun updateCustomerByCustomersId(
        customersId: String,
        firstName: String? = null,
        lastName: String? = null,
        city: String? = null,
        state: String? = null,
        postalCode: String? = null,
        company: String? = null,
        mrMs: String? = null,
        jobTitle: String? = null,
        businessPhone: String? = null,
        address1: String? = null,
        address2: String? = null,
        notes: String? = null,
    )

    fun deleteByCustomersId(customersId: String)

    fun existsByCustomersId(customersId: String)
}
