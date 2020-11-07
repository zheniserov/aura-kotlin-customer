package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.CalendarView
import com.aura.auracustomer.models.CalendarYearExpandable
import com.example.aura.R
import kotlinx.android.synthetic.main.payment_calendar_month_row.view.*
import kotlinx.android.synthetic.main.payment_calendar_row.view.*
import kotlin.collections.ArrayList

class CalendarAdapter(private val arrears: ArrayList<CalendarView>, private val years: ArrayList<CalendarYearExpandable>) : RecyclerView.Adapter<CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(
            R.layout.payment_calendar_row,
            parent,
            false
        )
        return CalendarViewHolder(inflater)
    }

//    private fun findByMonth(calendarView: CalendarView, date: String): Boolean {
//        val divided = calendarView.calendarPaymentDate.split("-")
//        val monthYear = divided[0]+divided[1]
//        return monthYear == date
//    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val calendarYearExpandable = years[position]
        holder.view.calendar_row_date.text = calendarYearExpandable.year
//        holder.view.setOnClickListener {
//            calendarYearExpandable.expandable = !calendarYearExpandable.expandable
//            if (!calendarYearExpandable.expandable) {
//                holder.view.payment_calendar_show_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
//                holder.view.payment_calendar_months_recycler_view.visibility = View.GONE
//            } else {
//                holder.view.payment_calendar_show_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
//                holder.view.payment_calendar_months_recycler_view.visibility = View.VISIBLE
//                holder.view.payment_calendar_months_recycler_view.layoutManager = LinearLayoutManager(holder.view.context)
//                holder.view.payment_calendar_months_recycler_view.adapter = CalendarMonthsAdapter(arrears)
//            }
//        }
    }

    override fun getItemCount(): Int = years.size
}

class CalendarViewHolder(val view: View) : RecyclerView.ViewHolder(view)

class CalendarMonthsAdapter(private val arrears: ArrayList<CalendarView>) : RecyclerView.Adapter<CalendarMonthsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarMonthsViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(
            R.layout.payment_calendar_month_row,
            parent,
            false
        )
        return CalendarMonthsViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CalendarMonthsViewHolder, position: Int) {
        val arrear = arrears[position]
        holder.view.calendar_month.text = arrear.calendarPaymentDate
        holder.view.calendar_arrear.text = arrear.calendarPaymentDue.toString()
    }

    override fun getItemCount(): Int = arrears.size

}

class CalendarMonthsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}


//val month = position+1
//val monthWithZero = if (month.toString().length == 1) "0$month" else month.toString()
//var arrear = 0.0
//arrears.filter { findByMonth(
//    it,
//    Calendar.getInstance()[Calendar.YEAR].toString()+monthWithZero
//) }.forEach { arrear += it.calendarPaymentDue }
//if (arrear == 0.0) {
//    holder.view.calendar_month_card.setBackgroundColor(holder.view.resources.getColor(android.R.color.holo_green_light))
//    holder.view.calendar_arrear.visibility = View.GONE
//} else {
//    holder.view.calendar_month_card.setBackgroundColor(holder.view.resources.getColor(android.R.color.holo_red_light))
//}
//holder.view.calendar_arrear.text = decimalFormatter(arrear)
//holder.view.payment_calendar_date.text = month.toString()