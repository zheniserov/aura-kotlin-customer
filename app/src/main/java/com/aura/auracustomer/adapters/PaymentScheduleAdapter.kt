package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.PaymentSchedule
import com.aura.auracustomer.utils.Helpers.dateFormatter
import com.aura.auracustomer.utils.Helpers.decimalFormatter
import com.example.aura.R
import kotlinx.android.synthetic.main.payment_schedule_card.view.*

class PaymentScheduleAdapter(private val paymentSchedules: ArrayList<PaymentSchedule>) : RecyclerView.Adapter<PaymentScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.payment_schedule_card, parent, false)
        return PaymentScheduleViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: PaymentScheduleViewHolder, position: Int) {
        val payment: PaymentSchedule = paymentSchedules[position]
        holder.view.payment_schedule_payment_date.text = "Дата взноса: ${dateFormatter(payment.paymentDate)}"
        holder.view.payment_schedule_amount_to_pay.text = "Сумма к оплате: ${decimalFormatter(payment.sum2)}"
        holder.view.payment_schedule_paid.text = "Оплачено: ${decimalFormatter(payment.paid)}"
    }

    override fun getItemCount(): Int = paymentSchedules.size
}

class PaymentScheduleViewHolder(val view: View) : RecyclerView.ViewHolder(view)