package com.aura.auracustomer.models

import java.io.Serializable

data class Service (
    val id: Long,
    val image: String,
    val dateOpen: String,
    val paymentDue: Double,
    val description: String,
    val paid: Double? = null
) : Serializable
