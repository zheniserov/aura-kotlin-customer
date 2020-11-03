package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aura.R
import kotlinx.android.synthetic.main.payment_calendar_card.view.*

class CalendarAdapter(private val months: Int) : RecyclerView.Adapter<CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.payment_calendar_card, parent, false)
        return CalendarViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.view.payment_calendar_date.text = (position+1).toString()
    }

    override fun getItemCount(): Int = months
}

class CalendarViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}