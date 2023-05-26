package com.example.kotlinapipg1

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("CASES")
data class Case(
    @Id var casesId: String,
    val party1: String,
    val party1Type: Party1Type,
    val party2: String,
    val party2Type: Party2Type,
    val caseNumber1: String,
    val caseNumber2: String,
    val jurisdiction: Jurisdiction,
    val notes: String
)

enum class Party1Type { PLAINTIFF, PETITIONER, APPELLANT }
enum class Party2Type { DEFENDANT, RESPONDENT, STATE }
enum class Jurisdiction(jurisdictionName: String) {
    SNOHOMISH_COUNTY("Snohomish County Superior Court"),
    KING_COUNTY("King County Superior Court"),
    PIERCE_COUNTY("Pierce County Superior Court"),
    USBC_WDWA("Western District of Washington"),
    USBC_EDWA("Eastern District of Washington")
}