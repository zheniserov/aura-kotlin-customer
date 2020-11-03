package com.aura.auracustomer.presenters

import android.content.Context
import com.aura.auracustomer.models.Customer
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.CustomerApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.utils.Helpers
import com.aura.auracustomer.utils.Helpers.exceptionHandler
import com.aura.auracustomer.views.ICustomerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ICustomerPresenter {
    fun getData(customerId: Long)
}

class CustomerPresenter(val iCustomerView: ICustomerView, val context: Context): ICustomerPresenter {

    override fun getData(customerId: Long) {
        val apiService = ServiceBuilder.buildService(CustomerApi::class.java)
        val callCustomer = apiService.getCustomerData(customerId)

        callCustomer.enqueue(object : Callback<ResponseHelper<Customer>> {
            override fun onFailure(call: Call<ResponseHelper<Customer>>, t: Throwable) {
                exceptionHandler(t, context)
                iCustomerView.onError(t.message!!)
            }

            override fun onResponse(call: Call<ResponseHelper<Customer>>, response: Response<ResponseHelper<Customer>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iCustomerView.onSuccess(response.body()!!.data)
                } else {
                    exceptionHandler(response.errorBody()!!, context)
                    iCustomerView.onError(response.errorBody()!!)
                }
            }
        })
    }
}