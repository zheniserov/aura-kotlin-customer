package com.aura.auracustomer.services

import com.aura.auracustomer.models.ResponseHelper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
    @GET("/ma-message/unreadMessageCount/{customerId}")
    fun getUnreadMessagesCount(@Path("customerId") customerId: Long): Call<ResponseHelper<Int>>
}