package com.aura.auracustomer.views

import com.aura.auracustomer.models.Payment

interface IPaymentsView {
    fun onSuccessPayments(payments: ArrayList<Payment>) {}
    fun onError(message: String) {}
    fun onSuccessPayment(payment: Payment) {}
}