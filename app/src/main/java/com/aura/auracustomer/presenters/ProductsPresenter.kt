package com.aura.auracustomer.presenters

import com.aura.auracustomer.models.Product
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.ProductsApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.views.IProductsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface IProductsPresenter {
    fun getAll(customerId: Long)
    fun getProduct(contractId: Long)
}

class ProductsPresenter(val iProductsView: IProductsView): IProductsPresenter {
    private val apiService = ServiceBuilder.buildService(ProductsApi::class.java)

    override fun getAll(customerId: Long) {
        val callAllContracts = apiService.getAllContracts(customerId)

        callAllContracts.enqueue(object : Callback<ResponseHelper<ArrayList<Product>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<Product>>>, t: Throwable) {
                iProductsView.onError(t.localizedMessage!!)
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<Product>>>, response: Response<ResponseHelper<ArrayList<Product>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iProductsView.onSuccessProducts(response.body()!!.data)
                }
            }
        })
    }

    override fun getProduct(contractId: Long) {
        val callContract = apiService.getProduct(contractId)

        callContract.enqueue(object : Callback<ResponseHelper<Product>> {
            override fun onResponse(
                call: Call<ResponseHelper<Product>>,
                response: Response<ResponseHelper<Product>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                    iProductsView.onSuccessProduct(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<ResponseHelper<Product>>, t: Throwable) {
                iProductsView.onError(t.localizedMessage!!)
            }

        })
    }

}