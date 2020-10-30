package com.aura.auracustomer.models

data class PaymentSchedule (
    val paymentTypeId: Long,
    val paymentDate: String,
    val paymentSum: Long,
    val paid: Long,
    val paymentScheduleNum: Long,
    val matnrName: String
)