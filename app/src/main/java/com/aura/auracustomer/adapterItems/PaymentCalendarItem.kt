package com.example.aura.adapterItems

import com.example.aura.R
import com.aura.auracustomer.models.PaymentCalendar
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.payment_calendar_card.view.*

class PaymentCalendarItem (val item: PaymentCalendar): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.payment_calendar_date.text = item.date
    }

    override fun getLayout(): Int {
        return R.layout.payment_calendar_card
    }
}