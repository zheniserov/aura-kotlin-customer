package com.aura.auracustomer.views

import com.aura.auracustomer.models.Customer

interface ICustomerView {
    fun onSuccess(data: Customer)
    fun onError(message: String) {}
}