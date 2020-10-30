package com.example.aura.adapterItems

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aura.R
import com.aura.auracustomer.fragments.DefrayalFragment
import com.aura.auracustomer.models.Payment
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.payment_card.view.*
import kotlinx.android.synthetic.main.payment_card_service.view.*

class AllPaymentsItem (private val payment: Payment): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        if (payment.name == "Услуга") {
            viewHolder.itemView.payment_service_title.text = payment.name
            viewHolder.itemView.payment_service_text1.text = "След. платеж: ${payment.nextPayment}"
            viewHolder.itemView.payment_service_text2.text = payment.dateTo
            viewHolder.itemView.payment_service_text3.text = payment.description
        } else {
            viewHolder.itemView.payment_title.text = payment.name
            viewHolder.itemView.payment_schedule_payed.text = "След. платеж: ${payment.nextPayment}"
            viewHolder.itemView.payment_text2.text = payment.dateTo
        }
    }

    override fun getLayout(): Int {
        return if (payment.name == "Услуга") {
            R.layout.payment_card_service
        } else {
            R.layout.payment_card
        }
    }

    private fun toDefrayal(context: Context, fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, DefrayalFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

}