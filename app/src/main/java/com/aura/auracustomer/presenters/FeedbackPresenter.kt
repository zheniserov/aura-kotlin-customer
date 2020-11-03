package com.aura.auracustomer.presenters

import android.content.Context
import com.aura.auracustomer.models.Error
import com.aura.auracustomer.models.Feedback
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.FeedbackApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.utils.Helpers.exceptionHandler
import com.aura.auracustomer.views.IFeedbackView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface IFeedbackPresenter {
    fun getFeedback(customerId: Long)
}

class FeedbackPresenter(val iFeedbackView: IFeedbackView, val context: Context): IFeedbackPresenter {

    override fun getFeedback(customerId: Long) {
        val apiService = ServiceBuilder.buildService(FeedbackApi::class.java)
        val callFeedback = apiService.getFeedback(customerId)

        callFeedback.enqueue(object : Callback<ResponseHelper<ArrayList<Feedback>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<Feedback>>>, t: Throwable) {
                exceptionHandler(t, context)
                iFeedbackView.onError(t.message!!)
            }

            override fun onResponse(
                call: Call<ResponseHelper<ArrayList<Feedback>>>,
                response: Response<ResponseHelper<ArrayList<Feedback>>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                    iFeedbackView.onSuccess(response.body()!!.data)
                } else {
                    exceptionHandler(response.errorBody()!!, context)
                    iFeedbackView.onError(response.errorBody()!!)
                }
            }
        })
    }
}