package com.aura.auracustomer.models

import java.io.Serializable

data class Product (
    val id: Long,
    val image: String,
    val contractId: Long,
    val tovarSerial: String,
    val contractDate: String,
    val price: Int,
    var paid: Int,
    val customerId: Int,
    val iinBin: String,
    val birthday: String,
    val lastName: String,
    val firstName: String,
    val middleName: String,
    val name: String,
    val matnrName: String,
    val lastServiceDate: String,
    val paymentScheduleNum: Int
) : Serializable

