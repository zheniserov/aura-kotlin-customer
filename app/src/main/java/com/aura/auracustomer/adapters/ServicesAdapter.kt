package com.aura.auracustomer.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.activities.ServiceActivity
import com.aura.auracustomer.models.Service
import com.example.aura.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.service_card.view.*

class ServicesAdapter(private val services: ArrayList<Service>) : RecyclerView.Adapter<ServicesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.service_card, parent, false)
        return ServicesViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        val image = "https://www.rain-del-queen.co.za/images/homePage/roboclean.png"
        val service: Service = services[position]
        holder.view.date_of_service_card.text = service.dateOpen
        holder.view.description_of_service_card.text = service.description
        holder.view.amount_of_service_card.text = service.paymentDue.toString() + " " + service.waers
        holder.view.arrears_of_serivce_card.text = "Задолженность: ${service.paid.toString()}"
        holder.view.service_card_pay_btn.visibility = if (service.paid != 0.0) View.VISIBLE else View.INVISIBLE
        holder.serviceId = service.id
        Picasso.get()
            .load(image)
            .into(holder.view.service_image)
    }

    override fun getItemCount(): Int = services.size
}

class ServicesViewHolder(val view: View, var serviceId: Long? = null) : RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, ServiceActivity::class.java)
            intent.putExtra("serviceId", serviceId)
            view.context.startActivity(intent)
        }
    }
}