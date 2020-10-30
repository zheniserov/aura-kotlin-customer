package com.aura.auracustomer.views

import com.aura.auracustomer.models.Service

interface IServicesView {
    fun onSuccess(services: ArrayList<Service>)
    fun onError(message: String)
}