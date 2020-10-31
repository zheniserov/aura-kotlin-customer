package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Customer
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.CustomerApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.ICustomerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ICustomerPresenter {
    fun getData(customerId: Long)
}

class CustomerPresenter(val iCustomerView: ICustomerView): ICustomerPresenter {

    override fun getData(customerId: Long) {
        val apiService = ServiceBuilder.buildService(CustomerApi::class.java)
        val callSignIn = apiService.getCustomerData(customerId)

        callSignIn.enqueue(object : Callback<ResponseHelper<Customer>> {
            override fun onFailure(call: Call<ResponseHelper<Customer>>, t: Throwable) {
                iCustomerView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseHelper<Customer>>, response: Response<ResponseHelper<Customer>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iCustomerView.onSuccess(response.body()!!.data)
                }
            }
        })
    }
}