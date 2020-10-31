package com.aura.auracustomer.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.CalendarViewActivity
import com.example.aura.adapterItems.AllPaymentsItem
import com.aura.auracustomer.models.Payment
import com.aura.auracustomer.presenters.IPaymentsPresenter
import com.aura.auracustomer.presenters.PaymentsPresenter
import com.aura.auracustomer.views.IPaymentsView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_all_payments.*

private const val ARG_PARAM1 = "payments"

class AllPaymentsFragment : Fragment() {
    private var payments: ArrayList<Payment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            payments = it.getSerializable(ARG_PARAM1) as ArrayList<Payment>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_payments, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        all_payments_recycler_view.layoutManager = LinearLayoutManager(this.requireContext())
//        all_payments_recycler_view.adapter =

        calendar_view.setOnClickListener {
            val intent = Intent(this.context, CalendarViewActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(payments: ArrayList<Payment>) =
            AllPaymentsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, payments)
                }
            }
    }
}