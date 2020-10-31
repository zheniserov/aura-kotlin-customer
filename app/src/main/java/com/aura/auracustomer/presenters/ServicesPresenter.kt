package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.models.Service
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.services.ServicesApi
import com.aura.auracustomer.views.IServicesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IServicesPresenter {
    fun getAll(customerId: Long)
    fun getService(serviceId: Long)
}

class ServicesPresenter(val iServicesView: IServicesView): IServicesPresenter {

    private val apiService = ServiceBuilder.buildService(ServicesApi::class.java)

    override fun getAll(customerId: Long) {
        val callSignIn = apiService.getAllServices(customerId)

        callSignIn.enqueue(object : Callback<ResponseHelper<ArrayList<Service>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<Service>>>, t: Throwable) {
                iServicesView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<Service>>>, response: Response<ResponseHelper<ArrayList<Service>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iServicesView.onSuccessServices(response.body()!!.data)
                }
            }
        })
    }

    override fun getService(serviceId: Long) {
        val callSignIn = apiService.getService(serviceId)

        callSignIn.enqueue(object : Callback<ResponseHelper<Service>> {
            override fun onFailure(call: Call<ResponseHelper<Service>>, t: Throwable) {
                iServicesView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseHelper<Service>>, response: Response<ResponseHelper<Service>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iServicesView.onSuccessService(response.body()!!.data)
                }
            }
        })
    }

}