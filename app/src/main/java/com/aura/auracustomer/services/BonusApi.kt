package com.aura.auracustomer.services

import com.aura.auracustomer.models.Bonus
import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BonusApi {
    @GET("/ma-customer-bonus/{customerId}")
    fun getBonuses(@Path("customerId") customerId: Long): Call<ResponseHelper<ArrayList<Bonus>>>
}