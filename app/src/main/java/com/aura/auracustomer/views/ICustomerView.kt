package com.aura.auracustomer.views

import com.aura.auracustomer.models.Customer

interface ICustomerView : BaseView {
    fun onSuccess(data: Customer)
}