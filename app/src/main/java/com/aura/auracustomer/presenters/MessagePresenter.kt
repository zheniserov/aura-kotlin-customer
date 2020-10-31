package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Message
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.MessageApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IMessageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IMessagePresenter {
    fun getAll(customerId: Long)
}

class MessagePresenter(val iMessageView: IMessageView): IMessagePresenter {

    override fun getAll(customerId: Long) {
        val apiService = ServiceBuilder.buildService(MessageApi::class.java)
        val callSignIn = apiService.getAllMessages(customerId)

        callSignIn.enqueue(object : Callback<ResponseHelper<ArrayList<Message>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<Message>>>, t: Throwable) {
                iMessageView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<Message>>>, response: Response<ResponseHelper<ArrayList<Message>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iMessageView.onSuccess(response.body()!!.data)
                }
            }
        })
    }
}