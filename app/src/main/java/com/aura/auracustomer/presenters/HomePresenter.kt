package com.aura.auracustomer.presenters

import android.content.Context
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.HomeApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.utils.Helpers
import com.aura.auracustomer.views.IHomeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IHomePresenter {
    fun getUnreadMessagesCount(customerId: Long)
}

class HomePresenter (val iHomeView: IHomeView, val context: Context) : IHomePresenter {
    val apiService = ServiceBuilder.buildService(HomeApi::class.java)

    override fun getUnreadMessagesCount(customerId: Long) {
        val callUnreadMessagesCount = apiService.getUnreadMessagesCount(customerId)
        callUnreadMessagesCount.enqueue(object : Callback<ResponseHelper<Int>> {
            override fun onResponse(
                call: Call<ResponseHelper<Int>>,
                response: Response<ResponseHelper<Int>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                    iHomeView.onSuccessUnreadMessagesCount(response.body()!!.data)
                } else {
                    Helpers.exceptionHandler(response.errorBody()!!, context)
                    iHomeView.onError(response.errorBody()!!)
                }
            }

            override fun onFailure(call: Call<ResponseHelper<Int>>, t: Throwable) {
                Helpers.exceptionHandler(t, context)
                t.message?.let { iHomeView.onError(it) }
            }

        })
    }
}