package com.aura.auracustomer.services

import com.aura.auracustomer.models.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesApi {
    @GET("/service/{contractId}")
    fun getAllServices(
        @Path("contractId") contractId: Long
    ): Call<ArrayList<Service>>
}