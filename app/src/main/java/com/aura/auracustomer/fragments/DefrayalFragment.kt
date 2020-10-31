package com.aura.auracustomer.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.ConfirmPayActivity
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.DefrayalAdapter
import com.aura.auracustomer.models.Defrayal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_defrayal.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DefrayalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val defrayals = arrayListOf(
        Defrayal("Roboclean S-Plus", 30000.toDouble(), "тенге"),
        Defrayal("Услуга", 40000.toDouble(), "тенге")
    )

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
        return inflater.inflate(R.layout.fragment_defrayal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Оплата"

        defrayal_recycler_view.layoutManager = LinearLayoutManager(this.requireContext())
        defrayal_recycler_view.adapter = DefrayalAdapter(defrayals)

    }



    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DefrayalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
