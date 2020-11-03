package com.aura.auracustomer.views

import android.widget.Toast
import com.aura.auracustomer.activities.ProductDetailsActivity
import com.aura.auracustomer.models.Product

interface IProductsView : BaseView {
    fun onSuccessProducts(products: ArrayList<Product>) {}
    fun onSuccessProduct(product: Product) {}
}