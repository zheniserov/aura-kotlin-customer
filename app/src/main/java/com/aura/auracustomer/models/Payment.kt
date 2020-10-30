package com.aura.auracustomer.models

data class Payment (
    val name: String,
    val nextPayment: Int,
    val dateTo: String,
    val description: String = ""
)