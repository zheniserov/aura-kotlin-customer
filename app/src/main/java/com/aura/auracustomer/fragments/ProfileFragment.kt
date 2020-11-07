package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.models.Customer
import com.aura.auracustomer.presenters.CustomerPresenter
import com.aura.auracustomer.presenters.ICustomerPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.utils.Helpers.dateFormatter
import com.aura.auracustomer.views.ICustomerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ICustomerView {
    private lateinit var customerPresenter: ICustomerPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = null

        customerPresenter = CustomerPresenter(this, this.requireContext())
        customer_data.visibility = View.INVISIBLE
        customerPresenter.getData(Constants.CUSTOMER_ID)
    }

    override fun onSuccess(data: Customer) {
        println(data)
        customer_data.visibility = View.VISIBLE
        profile_progress_bar.visibility = View.INVISIBLE
        profile_subtitle.text = data.countryName
        if (data.fizYur == 1) {
            profile_title.text = data.name
            profile_textView3.text = "Бухгалтер"
            profile_textView4.text = "Директор"
            textView19.text = data.accountant
            textView20.text = data.director
        } else {
            profile_title.text = data.customerFio
            profile_textView3.text = "ИИН/БИН"
            profile_textView4.text = "Дата рождения"
            textView19.text = data.iinBin
            textView20.text = dateFormatter(data.birthday!!)
        }
        profile_passport_number.text = "Номер паспорта: ${data.passportId ?: ""}"
        profile_date_of_issue.text = "Дата выдачи: ${dateFormatter(data.passportGivenDate!!)}"
        profile_issued.text = "Выдан: ${data.passportGivenBy ?: ""}"
        Picasso.get()
            .load(R.drawable.dicaprio)
            .into(profile_user_image)
        profile_mobile.text = "Мобильный телефон: ${data.mobile ?: ""}"
        profile_home.text = "Домашний телефон: ${data.telephone ?: ""}"
        profile_address_city.text = "Город: ${data.address ?: ""}"
        profile_address_reg.text = "Местожительство: ${data.addressReg ?: ""}"
        profile_address_work.text = "Место работы: ${data.addressWork ?: ""}"
    }

    override fun onError(error: Any) {
        profile_progress_bar.visibility = View.INVISIBLE
    }
}