package com.aura.auracustomer.services

import com.aura.auracustomer.models.Auth
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST


interface AuthorizationActivityApi {
    @POST("movie/popular?")
    fun signIn(
        @Field("phoneNumber") phoneNumber: String,
        @Field("sn") sn: Int
    ): Call<Auth>
}