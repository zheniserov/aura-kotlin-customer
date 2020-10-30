package com.aura.auracustomer.views

import com.aura.auracustomer.models.Product

interface IProductsView {
    fun onSuccess(products: ArrayList<Product>)
    fun onError(message: String)
}