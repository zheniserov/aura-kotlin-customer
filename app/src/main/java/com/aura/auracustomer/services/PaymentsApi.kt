package com.aura.auracustomer.services

import com.aura.auracustomer.models.Payment
import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PaymentsApi {
    @GET("/payment-schedule/list/{customerId}")
    fun getAllPayments(@Path("customerId") customerId: Long): Call<ResponseHelper<ArrayList<Payment>>>
}