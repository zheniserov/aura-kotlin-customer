package com.aura.auracustomer.views

import android.widget.Toast
import com.aura.auracustomer.activities.ProductDetailsActivity
import com.aura.auracustomer.models.Product

interface IProductsView {
    fun onSuccessProducts(products: ArrayList<Product>) {}
    fun onError(message: String) {}
    fun onSuccessProduct(product: Product) {}
}