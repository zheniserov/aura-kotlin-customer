package com.aura.auracustomer.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aura.auracustomer.adapters.CalendarAdapter
import com.aura.auracustomer.models.CalendarView
import com.aura.auracustomer.models.CalendarYearExpandable
import com.aura.auracustomer.presenters.CalendarViewPresenter
import com.aura.auracustomer.presenters.ICalendarViewPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.utils.Helpers.decimalFormatter
import com.aura.auracustomer.views.ICalendarViView
import com.example.aura.R
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import kotlinx.android.synthetic.main.activity_calendar_view.*
import java.time.LocalDate
import java.util.*

class CalendarViewActivity : AppCompatActivity(), ICalendarViView {
    private lateinit var gridLayoutManager: GridLayoutManager

    private lateinit var slidr: SlidrInterface
    private lateinit var calendarViewPresenter: ICalendarViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)

        // Off screenshot
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )


        slidr = Slidr.attach(this)

        calendarViewPresenter = CalendarViewPresenter(this, applicationContext)
        calendarViewPresenter.getArrears(Constants.CUSTOMER_ID)
//        calendarAdapter.setOnItemClickListener { item, _ ->
//            val calendarItem = item as PaymentCalendarItem
//            val intent = Intent(this, CalendarItemDetailsActivity::class.java)
//            intent.putExtra("data", calendarItem.item)
//            startActivity(intent)
//        }
    }

    fun goToBack(view: View) {
        onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }

    override fun onSuccess(arrears: ArrayList<CalendarView>) {
        val years = arrayListOf<CalendarYearExpandable>(
            CalendarYearExpandable(2001.toString(), false),
            CalendarYearExpandable(2002.toString(), false),
            CalendarYearExpandable(2003.toString(), false),
            CalendarYearExpandable(2004.toString(), false),
            CalendarYearExpandable(2006.toString(), false),
            CalendarYearExpandable(2007.toString(), false),
            CalendarYearExpandable(2008.toString(), false),
            CalendarYearExpandable(2009.toString(), false),
            CalendarYearExpandable(2011.toString(), false),
            CalendarYearExpandable(2021.toString(), false),
            CalendarYearExpandable(2101.toString(), false),
            CalendarYearExpandable(2501.toString(), false),
            CalendarYearExpandable(2081.toString(), false)
        )
        arrears.forEach {
            val divided = it.calendarPaymentDate.split("-")
            val year = divided[0]
            if (CalendarYearExpandable(year, false) !in years) {
                years.add(CalendarYearExpandable(year, false))
            }
        }
//        gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        calendarViewRecyclerView.layoutManager = LinearLayoutManager(this)
        calendarViewRecyclerView.adapter = CalendarAdapter(arrears, years)
    }

//    private fun initData(arrears: ArrayList<CalendarView>) {
//        val prevYear = Calendar.getInstance()
//        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
//        prevYear.add(Calendar.YEAR, -1)
//        calendar_view_last_year.text = prevYear[Calendar.YEAR].toString()
//        calendar_view_current_year.text = currentYear.toString()
//        var arrear = 0.0
//        arrears.forEach { arrear += it.calendarPaymentDue }
//        calendar_view_total_arrears_of_current_year.text = "На $currentYear - ${decimalFormatter(arrear)}"
//    }
}