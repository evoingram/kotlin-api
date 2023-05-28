package com.example.kotlinapipg1.dataClasses

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.core.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.node.*
import com.fasterxml.jackson.module.kotlin.*

val mapper = jacksonObjectMapper().apply {
    propertyNamingStrategy = PropertyNamingStrategies.LOWER_CAMEL_CASE
    setSerializationInclusion(JsonInclude.Include.NON_NULL)
}

data class ValidatedAddress(
    @get:JsonProperty("ErrorCode")
    @field:JsonProperty("ErrorCode")
    val errorCode: Long? = null,

    @get:JsonProperty("ErrorMessage")
    @field:JsonProperty("ErrorMessage")
    val errorMessage: String? = null,

    @get:JsonProperty("AddressLine1")
    @field:JsonProperty("AddressLine1")
    val addressLine1: String? = null,

    @get:JsonProperty("AddressLine2")
    @field:JsonProperty("AddressLine2")
    val addressLine2: String? = null,

    @get:JsonProperty("Number")
    @field:JsonProperty("Number")
    val number: String? = null,

    @get:JsonProperty("PreDir")
    @field:JsonProperty("PreDir")
    val preDir: String? = null,

    @get:JsonProperty("Street")
    @field:JsonProperty("Street")
    val street: String? = null,

    @get:JsonProperty("Suffix")
    @field:JsonProperty("Suffix")
    val suffix: String? = null,

    @get:JsonProperty("PostDir")
    @field:JsonProperty("PostDir")
    val postDir: String? = null,

    @get:JsonProperty("Sec")
    @field:JsonProperty("Sec")
    val sec: String? = null,

    @get:JsonProperty("SecNumber")
    @field:JsonProperty("SecNumber")
    val secNumber: String? = null,

    @get:JsonProperty("SecValidated")
    @field:JsonProperty("SecValidated")
    val secValidated: Boolean? = null,

    @get:JsonProperty("City")
    @field:JsonProperty("City")
    val city: String? = null,

    @get:JsonProperty("State")
    @field:JsonProperty("State")
    val state: String? = null,

    @get:JsonProperty("Zip")
    @field:JsonProperty("Zip")
    val zip: String? = null,

    @get:JsonProperty("Zip4")
    @field:JsonProperty("Zip4")
    val zip4: String? = null,

    @get:JsonProperty("UspsCarrierRoute")
    @field:JsonProperty("UspsCarrierRoute")
    val uspsCarrierRoute: String? = null,

    @get:JsonProperty("County")
    @field:JsonProperty("County")
    val county: String? = null,

    @get:JsonProperty("StateFP")
    @field:JsonProperty("StateFP")
    val stateFP: String? = null,

    @get:JsonProperty("CountyFP")
    @field:JsonProperty("CountyFP")
    val countyFP: String? = null,

    @get:JsonProperty("CensusTract")
    @field:JsonProperty("CensusTract")
    val censusTract: String? = null,

    @get:JsonProperty("CensusBlock")
    @field:JsonProperty("CensusBlock")
    val censusBlock: String? = null,

    @get:JsonProperty("Latitude")
    @field:JsonProperty("Latitude")
    val latitude: Double? = null,

    @get:JsonProperty("Longitude")
    @field:JsonProperty("Longitude")
    val longitude: Double? = null,

    @get:JsonProperty("GeoPrecision")
    @field:JsonProperty("GeoPrecision")
    val geoPrecision: Long? = null,

    @get:JsonProperty("TimeZoneOffset")
    @field:JsonProperty("TimeZoneOffset")
    val timeZoneOffset: Long? = null,

    @get:JsonProperty("DstObserved")
    @field:JsonProperty("DstObserved")
    val dstObserved: Boolean? = null,

    @get:JsonProperty("PlaceFP")
    @field:JsonProperty("PlaceFP")
    val placeFP: Long? = null,

    @get:JsonProperty("CityMunicipality")
    @field:JsonProperty("CityMunicipality")
    val cityMunicipality: String? = null,

    @get:JsonProperty("SalesTaxRate")
    @field:JsonProperty("SalesTaxRate")
    val salesTaxRate: Double? = null,

    @get:JsonProperty("SalesTaxJurisdiction")
    @field:JsonProperty("SalesTaxJurisdiction")
    val salesTaxJurisdiction: Long? = null
) {
    fun toJson() = mapper.writeValueAsString(this)

    companion object {
        fun fromJson(json: String): ValidatedAddress {
            return mapper.readValue<ValidatedAddress>(json)
        }
    }
}