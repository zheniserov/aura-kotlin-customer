package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.ServicesAdapter
import com.aura.auracustomer.models.Service
import com.aura.auracustomer.presenters.IServicesPresenter
import com.aura.auracustomer.presenters.ServicesPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.views.IServicesView
import kotlinx.android.synthetic.main.fragment_services.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ServicesFragment : Fragment(), IServicesView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var servicePresenter: IServicesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Услуги"
        servicePresenter = ServicesPresenter(this)
        servicePresenter.getAll(Constants.CUSTOMER_ID)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServicesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onSuccess(services: ArrayList<Service>) {
        services_recycler_view.layoutManager = LinearLayoutManager(this.requireContext())
        services_recycler_view.adapter = ServicesAdapter(services)
    }

    override fun onError(message: String) {
        println("Error: $message, Services")
    }
}