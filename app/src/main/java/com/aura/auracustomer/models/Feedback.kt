package com.aura.auracustomer.models


data class Feedback (
    val id: Int,
    val image: String,
    val customer: Customer,
    val feedbackText: String,
    val feedbackDate: String,
    val parentId: Long,
    val Staff: Staff
)
