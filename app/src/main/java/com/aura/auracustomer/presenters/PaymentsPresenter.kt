package com.aura.auracustomer.presenters

import android.content.Context
import com.aura.auracustomer.models.PaymentSchedule
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.PaymentsApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.utils.Helpers.exceptionHandler
import com.aura.auracustomer.views.IPaymentsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IPaymentsPresenter {
    fun getAll(customerId: Long)
    fun getPaymentsSchedule(awkey: Long, bukrs: String)
}

class PaymentsPresenter(val iPaymentsView: IPaymentsView, val context: Context): IPaymentsPresenter {
    private val apiService = ServiceBuilder.buildService(PaymentsApi::class.java)

    override fun getAll(customerId: Long) {
        val callPayments = apiService.getAllPayments(customerId)

        callPayments.enqueue(object : Callback<ResponseHelper<ArrayList<PaymentSchedule>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<PaymentSchedule>>>, t: Throwable) {
                exceptionHandler(t, context)
                iPaymentsView.onError(t.message!!)
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<PaymentSchedule>>>, response: Response<ResponseHelper<ArrayList<PaymentSchedule>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iPaymentsView.onSuccessPayments(response.body()!!.data)
                } else {
                    exceptionHandler(response.errorBody()!!, context)
                    iPaymentsView.onError(response.errorBody()!!)
                }
            }
        })
    }

    override fun getPaymentsSchedule(awkey: Long, bukrs: String) {
        val callPaymentsSchedule = apiService.getPaymentsScheduleByAwkeyBukrs(awkey, bukrs)
        callPaymentsSchedule.enqueue(object : Callback<ResponseHelper<ArrayList<PaymentSchedule>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<PaymentSchedule>>>, t: Throwable) {
                exceptionHandler(t, context)
                iPaymentsView.onError(t.message!!)
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<PaymentSchedule>>>, response: Response<ResponseHelper<ArrayList<PaymentSchedule>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iPaymentsView.onSuccessPaymentsSchedule(response.body()!!.data)
                } else {
                    exceptionHandler(response.errorBody()!!, context)
                    iPaymentsView.onError(response.errorBody()!!)
                }
            }
        })
    }

}