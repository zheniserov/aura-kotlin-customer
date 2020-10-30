package com.example.aura.adapterItems

import com.example.aura.R
import com.aura.auracustomer.models.Slider
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.home_slider_card.view.*

class SliderItem (val slider: Slider): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get()
            .load(slider.image)
            .into(viewHolder.itemView.slider_image)

    }

    override fun getLayout(): Int {
        return R.layout.home_slider_card
    }
}