package com.aura.auracustomer.services

import com.aura.auracustomer.models.PaymentSchedule
import com.aura.auracustomer.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {
    @GET("contract/{customerId}")
    fun getAllContracts(
        @Path("customerId") movieId: Long
    ): Call<ArrayList<Product>>

    @GET("payment-schedule/num/{paymentScheduleNum}")
    fun getPaymentSchedule(
        @Path("paymentScheduleNum") paymentScheduleNum: Long
    ): Call<ArrayList<PaymentSchedule>>
}