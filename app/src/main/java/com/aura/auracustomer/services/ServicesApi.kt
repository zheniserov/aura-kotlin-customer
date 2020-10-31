package com.aura.auracustomer.services

import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.models.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesApi {
    @GET("/service/customer/{customerId}")
    fun getAllServices(@Path("customerId") customerId: Long): Call<ResponseHelper<ArrayList<Service>>>

    @GET("service/{id}")
    fun getService(@Path("id") id: Long): Call<ResponseHelper<Service>>
}