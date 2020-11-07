package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.BonusAdapter
import com.aura.auracustomer.models.Bonus
import com.aura.auracustomer.presenters.BonusPresenter
import com.aura.auracustomer.presenters.IBonusPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.utils.Helpers.decimalFormatter
import com.aura.auracustomer.views.IBonusView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_bonuses.*

class BonusesFragment : Fragment(), IBonusView {

    private lateinit var bonusPresenter: IBonusPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bonuses, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.bonuses)
        bonusPresenter = BonusPresenter(this, this.requireContext())
        bonusPresenter.getBonuses(Constants.CUSTOMER_ID)
        hideProgressBar(false)
    }

    override fun onSuccess(bonuses: ArrayList<Bonus>) {
        bonuses_recycler_view.layoutManager = LinearLayoutManager(this.context)
        bonuses_recycler_view.adapter = BonusAdapter(bonuses)
        val confirmedBonuses = bonuses.filter { it.confirmedByCustomer == 1 }
        var total = 0.0
        confirmedBonuses.forEach {
            if (it.drcrk == "H") {
                total -= it.amount
            } else {
                total += it.amount
            }
        }
        bonust_total.text = decimalFormatter(total) + " KZT"
        hideProgressBar(true)
    }

    override fun onError(error: Any) {
        hideProgressBar(true)
    }

    private fun hideProgressBar(visibility: Boolean) {
        if (visibility) {
            bonus_progress_bar.visibility = View.INVISIBLE
            bonuses_recycler_view.visibility = View.VISIBLE
        } else {
            bonus_progress_bar.visibility = View.VISIBLE
            bonuses_recycler_view.visibility = View.INVISIBLE
        }
    }
}