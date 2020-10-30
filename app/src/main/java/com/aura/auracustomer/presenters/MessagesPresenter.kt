package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Message
import com.aura.auracustomer.services.MessagesApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IMessagesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IMessagesPresenter {
    fun getAll(customerId: Long)
}

class MessagesPresenter(val iMessagesView: IMessagesView): IMessagesPresenter {

    override fun getAll(customerId: Long) {
        val apiService = ServiceBuilder.buildService(MessagesApi::class.java)
        val callSignIn = apiService.getAllMessages(customerId)

        callSignIn.enqueue(object : Callback<ArrayList<Message>> {
            override fun onFailure(call: Call<ArrayList<Message>>, t: Throwable) {
                iMessagesView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Message>>, response: Response<ArrayList<Message>>) {
                if (response.isSuccessful) {
                    iMessagesView.onSuccess(response.body()!!)
                }
            }
        })
    }

}