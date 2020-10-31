package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.models.Payment
import com.aura.auracustomer.presenters.IPaymentsPresenter
import com.aura.auracustomer.presenters.PaymentsPresenter
import com.aura.auracustomer.utils.TabLayoutFragmentAdapter
import com.aura.auracustomer.views.IPaymentsView
import kotlinx.android.synthetic.main.fragment_payments.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PaymentsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymentsFragment : Fragment(), IPaymentsView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var paymentsPresenter: IPaymentsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payments, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Платежи"


        paymentsPresenter = PaymentsPresenter(this)
    }

    override fun onSuccessPayments(payments: ArrayList<Payment>) {
        val titles = ArrayList<String>()
        val fragments = ArrayList<Fragment>()

        titles.add("Все платежи")
        titles.add("История")

//        fragments.add(AllPaymentsFragment.newInstance())
        fragments.add(PaymentsHistoryFragment())

        val fragmentAdapter = TabLayoutFragmentAdapter(childFragmentManager, fragments, titles)
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PaymentsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaymentsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}