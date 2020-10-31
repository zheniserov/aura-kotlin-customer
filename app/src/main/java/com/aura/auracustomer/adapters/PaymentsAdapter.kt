package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.Payment
import com.example.aura.R


class PaymentsAdapter(private val payments: ArrayList<Payment>) : RecyclerView.Adapter<PaymentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.payment_card, parent, false)
        return PaymentsViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val payment: Payment = payments[position]
    }

    override fun getItemCount(): Int = payments.size
}

class PaymentsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}