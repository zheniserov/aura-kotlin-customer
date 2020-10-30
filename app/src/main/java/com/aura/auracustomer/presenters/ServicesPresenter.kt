package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Service
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.services.ServicesApi
import com.aura.auracustomer.views.IServicesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IServicesPresenter {
    fun getAll(customerId: Long)
}

class ServicesPresenter(val iServicesView: IServicesView): IServicesPresenter {

    override fun getAll(customerId: Long) {
        val apiService = ServiceBuilder.buildService(ServicesApi::class.java)
        val callSignIn = apiService.getAllServices(customerId)

        callSignIn.enqueue(object : Callback<ArrayList<Service>> {
            override fun onFailure(call: Call<ArrayList<Service>>, t: Throwable) {
                println(t.message)
                iServicesView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Service>>, response: Response<ArrayList<Service>>) {
                if (response.isSuccessful) {
                    println(response.body()!!)
                    iServicesView.onSuccess(response.body()!!)
                }
            }
        })
    }

}