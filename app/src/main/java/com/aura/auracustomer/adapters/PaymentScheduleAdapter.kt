package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.PaymentSchedule
import com.example.aura.R
import kotlinx.android.synthetic.main.payment_schedule_card.view.*

class PaymentScheduleAdapter(private val paymentSchedules: ArrayList<PaymentSchedule>) : RecyclerView.Adapter<PaymentScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.payment_schedule_card, parent, false)
        return PaymentScheduleViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: PaymentScheduleViewHolder, position: Int) {
        val payment: PaymentSchedule = paymentSchedules[position]
        holder.view.payment_schedule_payment_date.text = payment.paymentDate
        holder.view.payment_schedule_amount_to_pay.text = payment.sum2.toString()
        holder.view.payment_schedule_paid.text = payment.paid.toString()
    }

    override fun getItemCount(): Int = paymentSchedules.size
}

class PaymentScheduleViewHolder(val view: View) : RecyclerView.ViewHolder(view)