package com.aura.auracustomer.models

data class ResponseHelper <T> (
    val success: Boolean,
    val data: T
)