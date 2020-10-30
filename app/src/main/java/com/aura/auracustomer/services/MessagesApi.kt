package com.aura.auracustomer.services

import com.aura.auracustomer.models.Message
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MessagesApi {
    @GET("/ma-message/{customerId}")
    fun getAllMessages(
        @Path("customerId") movieId: Long
    ): Call<ArrayList<Message>>
}