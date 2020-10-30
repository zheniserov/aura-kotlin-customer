package com.example.aura.adapterItems

import com.example.aura.R
import com.aura.auracustomer.models.PaymentSchedule
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.payment_schedule_card.view.*

class PaymentScheduleItem(val paymentSchedule: PaymentSchedule): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.payment_schedule_payment_date.text = paymentSchedule.paymentDate
//        viewHolder.itemView.payment_schedule_amount_to_pay.text = paymentSchedule.amountToPay
//        viewHolder.itemView.payment_schedule_payed.text = paymentSchedule.payed
    }

    override fun getLayout(): Int {
        return R.layout.payment_schedule_card
    }
}