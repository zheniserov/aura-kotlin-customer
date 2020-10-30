package com.example.aura.adapterItems

import android.view.View
import com.example.aura.R
import com.aura.auracustomer.models.Bonus
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.bonus_card.view.*

class BonusItem (private val bonus: Bonus): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.bonuses_title.text = bonus.description
        viewHolder.itemView.bonuses_date.text = bonus.date
        viewHolder.itemView.bonuses_product_name.text = bonus.product_name

        if (bonus.confirmed) {
            viewHolder.itemView.bonus_btn.visibility = View.VISIBLE
        }
    }

    override fun getLayout(): Int {
        return R.layout.bonus_card
    }

}