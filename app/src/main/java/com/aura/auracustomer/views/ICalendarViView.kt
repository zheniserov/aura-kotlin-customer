package com.aura.auracustomer.views

import com.aura.auracustomer.models.CalendarView

interface ICalendarViView : BaseView {
    fun onSuccess(arrears: ArrayList<CalendarView>)
}