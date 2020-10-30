package com.aura.auracustomer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aura.auracustomer.models.Message
import com.example.aura.R
import kotlinx.android.synthetic.main.message_card.view.*

class MessagesAdapter(private val messages: ArrayList<Message>) : RecyclerView.Adapter<MessagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return MessagesViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        val message: Message = messages[position]
        holder.view.message_card_message.text = message.message
        holder.view.message_card_date.text = message.date
        holder.view.message_card_btn.text = if (message.messageType <= 2) "Оплатить" else "Подтвердить"
    }

    override fun getItemCount(): Int = messages.size
}

class MessagesViewHolder(val view: View) : RecyclerView.ViewHolder(view)