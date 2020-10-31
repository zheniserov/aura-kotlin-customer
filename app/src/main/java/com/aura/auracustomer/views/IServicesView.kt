package com.aura.auracustomer.views

import android.widget.Toast
import com.aura.auracustomer.activities.ServiceActivity
import com.aura.auracustomer.models.Service

interface IServicesView {
    fun onSuccessServices(services: ArrayList<Service>) {}
    fun onError(message: String) {}
    fun onSuccessService(service: Service) {}
}