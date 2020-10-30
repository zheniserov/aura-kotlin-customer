package com.example.aura.adapterItems

import com.example.aura.R
import com.aura.auracustomer.models.HistoryPayment
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.payment_card_service.view.*

class HistoryPaymentItem (val item: HistoryPayment): Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.payment_card_service
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.payment_service_title.text = item.name
        viewHolder.itemView.payment_service_text1.text = "Сумма: ${item.amount}"
        viewHolder.itemView.payment_service_text2.text = item.date
        viewHolder.itemView.payment_service_text3.text = item.status

    }

}