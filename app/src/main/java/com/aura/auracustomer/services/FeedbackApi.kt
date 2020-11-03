package com.aura.auracustomer.services

import com.aura.auracustomer.models.Feedback
import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedbackApi {
    @GET("/ma-feedback/{customerId}")
    fun getFeedback(@Path("customerId") customerId: Long): Call<ResponseHelper<ArrayList<Feedback>>>
}