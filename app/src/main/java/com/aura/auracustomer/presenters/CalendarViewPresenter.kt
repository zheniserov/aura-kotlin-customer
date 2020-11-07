package com.aura.auracustomer.presenters

import android.content.Context
import com.aura.auracustomer.models.CalendarView
import com.aura.auracustomer.models.Customer
import com.aura.auracustomer.models.ResponseHelper
import com.aura.auracustomer.services.CalendarViewApi
import com.aura.auracustomer.services.CustomerApi
import com.aura.auracustomer.services.ServiceBuilder
import com.aura.auracustomer.utils.Helpers
import com.aura.auracustomer.views.ICalendarViView
import com.aura.auracustomer.views.ICustomerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ICalendarViewPresenter {
    fun getArrears(customerId: Long)
}

class CalendarViewPresenter(val iCalendarViView: ICalendarViView, val context: Context): ICalendarViewPresenter {

    override fun getArrears(customerId: Long) {
        val apiService = ServiceBuilder.buildService(CalendarViewApi::class.java)
        val callArrears = apiService.getArrears(customerId)

        callArrears.enqueue(object : Callback<ResponseHelper<ArrayList<CalendarView>>> {
            override fun onFailure(call: Call<ResponseHelper<ArrayList<CalendarView>>>, t: Throwable) {
                Helpers.exceptionHandler(t, context)
                iCalendarViView.onError(t.message!!)
            }

            override fun onResponse(call: Call<ResponseHelper<ArrayList<CalendarView>>>, response: Response<ResponseHelper<ArrayList<CalendarView>>>) {
                if (response.isSuccessful && response.body()!!.success) {
                    iCalendarViView.onSuccess(response.body()!!.data)
                } else {
                    Helpers.exceptionHandler(response.errorBody()!!, context)
                    iCalendarViView.onError(response.errorBody()!!)
                }
            }
        })
    }
}