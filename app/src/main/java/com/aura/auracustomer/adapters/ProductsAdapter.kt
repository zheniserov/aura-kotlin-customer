package com.aura.auracustomer.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aura.R
import com.aura.auracustomer.activities.ProductDetailsActivity
import com.aura.auracustomer.models.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_card.view.*

class ProductAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product: Product = products[position]
        holder.view.product_title.text = product.matnrName
        holder.view.purchase_date.text = product.contractDate
        holder.view.service_date.text = product.lastServiceDate
        holder.view.purchase_date.text = product.contractDate
        holder.view.payment.text = product.price.toString()
        val image = "https://www.rain-del-queen.co.za/images/homePage/roboclean.png"
        Picasso.get()
            .load(image)
            .into(holder.view.product_image)
        if(product.paid == 1){
            holder.view.payment.visibility = View.GONE
            holder.view.payment_text.visibility = View.GONE
            holder.view.payment_till.visibility = View.GONE
            holder.view.payment_till_text.visibility = View.GONE
            holder.view.product_btn.visibility = View.GONE
            holder.view.payed.visibility = View.VISIBLE
        }
        holder.contractId = product.contractId
    }

    override fun getItemCount(): Int = products.size
}

class ProductViewHolder(val view: View, var contractId: Long? = null) : RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, ProductDetailsActivity::class.java)
            println(contractId)
            intent.putExtra("contractId", contractId)
            view.context.startActivity(intent)
        }
    }
}