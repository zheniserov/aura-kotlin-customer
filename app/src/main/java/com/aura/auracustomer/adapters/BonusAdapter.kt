package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.Bonus
import com.example.aura.R
import kotlinx.android.synthetic.main.bonus_card.view.*

class BonusAdapter(private val bonuses: ArrayList<Bonus>) : RecyclerView.Adapter<BonusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BonusViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.bonus_card, parent, false)
        return BonusViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BonusViewHolder, position: Int) {
        val bonus: Bonus = bonuses[position]
        val characterForAmount = if (bonus.drcrk == "H") "-" else "+"
        holder.view.bonuses_title.text = bonus.maBonusTypeName
        holder.view.bonuses_amount.text = "Сумма: $characterForAmount${bonus.amount} ${bonus.waers}"
        holder.view.bonuses_date.text = bonus.operationDate
        if (bonus.confirmedByCustomer == 0) {
            holder.view.bonus_btn.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = bonuses.size
}

class BonusViewHolder(val view: View) : RecyclerView.ViewHolder(view)