package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Message
import com.aura.auracustomer.models.Payment
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.MessageApi
import com.aura.auracustomer.services.PaymentsApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IPaymentsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IPaymentsPresenter {
    fun getAll(customerId: Long)
}

class PaymentsPresenter(val iPaymentsView: IPaymentsView): IPaymentsPresenter {

    override fun getAll(customerId: Long) {
        val apiService = ServiceBuilder.buildService(PaymentsApi::class.java)
        val callSignIn = apiService.getAllPayments(customerId)

        callSignIn.enqueue(object : Callback<ResponseHelper<ArrayList<Payment>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<Payment>>>, t: Throwable) {
                iPaymentsView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<Payment>>>, response: Response<ResponseHelper<ArrayList<Payment>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iPaymentsView.onSuccessPayments(response.body()!!.data)
                }
            }
        })
    }

}