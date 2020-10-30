package com.aura.auracustomer.services

import com.aura.auracustomer.models.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesApi {
    @GET("/service/customer/{customerId}")
    fun getAllServices(
        @Path("customerId") customerId: Long
    ): Call<ArrayList<Service>>
}