package com.example.kotlinapipg1.services

import com.example.kotlinapipg1.dataClasses.ValidatedAddress
import com.example.kotlinapipg1.repositories.AddressValidationRepository
import com.example.kotlinapipg1.utils.Constants.ADDRESS_VALIDATION_URL
import mu.two.KotlinLogging
import org.springframework.stereotype.Service
import kotlin.coroutines.suspendCoroutine

@Service
class AddressValidationService(private val okHttpClientService: OkHttpClientService) : AddressValidationRepository {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    override suspend fun validateAddress(): ValidatedAddress = suspendCoroutine { continuation ->
        val addressLine1 = "506+Fourth+Avenue+Unit+1"
        val addressLine2 = "Asbury+Prk+NJ"
        val urlWithQueryString = "${ADDRESS_VALIDATION_URL}?" +
                "AddressLine1=$addressLine1&" +
                "AddressLine2=$addressLine2"

        okHttpClientService.httpRequest(urlWithQueryString) { responseBody, exception ->
            if (exception != null) {
                exception.printStackTrace()
                continuation.resumeWith(Result.failure(exception))
            } else {
                logger.info(responseBody)
                val avr = ValidatedAddress.fromJson(responseBody.toString())
                continuation.resumeWith(Result.success(avr))
            }
        }
    }
}