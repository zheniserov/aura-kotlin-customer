package com.aura.auracustomer.services

import com.aura.auracustomer.models.Customer
import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerApi {
    @GET("customer/{id}")
    fun getCustomerData(@Path("id") id: Long): Call<ResponseHelper<Customer>>
}