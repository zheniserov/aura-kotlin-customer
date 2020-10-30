package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Service
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.services.ServicesApi
import com.aura.auracustomer.views.IServicesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IServicesPresenter {
    fun getAll(contractId: Long)
}

class ServicesPresenter(val iServicesView: IServicesView): IServicesPresenter {

    override fun getAll(contractId: Long) {
        val apiService = ServiceBuilder.buildService(ServicesApi::class.java)
        val callSignIn = apiService.getAllServices(contractId)

        callSignIn.enqueue(object : Callback<ArrayList<Service>> {
            override fun onFailure(call: Call<ArrayList<Service>>, t: Throwable) {
                iServicesView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Service>>, response: Response<ArrayList<Service>>) {
                if (response.isSuccessful) {
                    iServicesView.onSuccess(response.body()!!)
                }
            }
        })
    }

}