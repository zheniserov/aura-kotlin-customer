package com.aura.auracustomer.views

import android.widget.Toast
import com.aura.auracustomer.activities.ServiceActivity
import com.aura.auracustomer.models.Service

interface IServicesView : BaseView {
    fun onSuccessServices(services: ArrayList<Service>) {}
    fun onSuccessService(service: Service) {}
}