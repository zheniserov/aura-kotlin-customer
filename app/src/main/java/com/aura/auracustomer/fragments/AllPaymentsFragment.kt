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
import com.aura.auracustomer.adapters.PaymentsAdapter
import com.aura.auracustomer.models.PaymentSchedule
import kotlinx.android.synthetic.main.fragment_all_payments.*

private const val ARG_PARAM1 = "payments"

class AllPaymentsFragment : Fragment() {
    private var paymentSchedules: ArrayList<PaymentSchedule>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paymentSchedules = it.getSerializable(ARG_PARAM1) as ArrayList<PaymentSchedule>
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

        all_payments_recycler_view.layoutManager = LinearLayoutManager(this.requireContext())
        all_payments_recycler_view.adapter = PaymentsAdapter(paymentSchedules!!)

        calendar_view.setOnClickListener {
            val intent = Intent(this.context, CalendarViewActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(paymentSchedules: ArrayList<PaymentSchedule>) =
            AllPaymentsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, paymentSchedules)
                }
            }
    }
}