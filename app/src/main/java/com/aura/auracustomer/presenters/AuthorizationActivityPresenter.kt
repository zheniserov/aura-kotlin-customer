package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Auth
import com.aura.auracustomer.services.AuthorizationActivityApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IAuthorizationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IAuthorizationActivityPresenter {
    fun signIn(phoneNumber: String, sn: Int)
}


class AuthorizationActivityPresenter(val iAuthView: IAuthorizationView):
    IAuthorizationActivityPresenter {


    override fun signIn(phoneNumber: String, sn: Int) {
        val apiService = ServiceBuilder.buildService(AuthorizationActivityApi::class.java)
        val callSignIn = apiService.signIn(phoneNumber, sn)

        callSignIn.enqueue(object : Callback<Auth> {
            override fun onFailure(call: Call<Auth>, t: Throwable) {
                iAuthView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<Auth>, response: Response<Auth>) {
                iAuthView.onSuccess()


            }

        })
    }

}