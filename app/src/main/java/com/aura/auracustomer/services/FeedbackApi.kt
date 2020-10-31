package com.aura.auracustomer.services

import com.aura.auracustomer.models.Message
import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedbackApi {
    @GET("/ma-message/{customerId}")
    fun getAllMessages(@Path("customerId") customerId: Long): Call<ResponseHelper<ArrayList<Message>>>
}