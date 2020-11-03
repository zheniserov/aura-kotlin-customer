package com.aura.auracustomer.views

import com.aura.auracustomer.models.PaymentSchedule

interface IPaymentsView : BaseView {
    fun onSuccessPayments(paymentSchedules: ArrayList<PaymentSchedule>) {}
    fun onSuccessPayment(paymentSchedule: PaymentSchedule) {}
    fun onSuccessPaymentsSchedule(paymentSchedules: ArrayList<PaymentSchedule>) {}
}