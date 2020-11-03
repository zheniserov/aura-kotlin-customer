package com.aura.auracustomer.models

data class PaymentSchedule (
    val paymentTypeId: Int,
    val paymentDate: String,
    val sum2: Double,
    val paid: Double,
    val paymentScheduleNum: Int,
    val matnrName: String,
    val serviceDescription: String
)