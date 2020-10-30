package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.PaymentSchedule
import com.aura.auracustomer.models.Product
import com.aura.auracustomer.services.ProductsApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IProductsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IProductsPresenter {
    fun getAll(customerId: Long)
}

class ProductsPresenter(val iProductsView: IProductsView): IProductsPresenter {

    override fun getAll(customerId: Long) {
        val apiService = ServiceBuilder.buildService(ProductsApi::class.java)
        val callAllContracts = apiService.getAllContracts(customerId)

        callAllContracts.enqueue(object : Callback<ArrayList<Product>> {
            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                iProductsView.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Product>>, response: Response<ArrayList<Product>>) {
                if (response.isSuccessful) {
                    iProductsView.onSuccess(response.body()!!)
                }
            }
        })
    }

}