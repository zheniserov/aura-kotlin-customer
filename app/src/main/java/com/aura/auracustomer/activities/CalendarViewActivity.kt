package com.aura.auracustomer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.aura.auracustomer.adapters.CalendarAdapter
import com.example.aura.R
import com.example.aura.adapterItems.PaymentCalendarItem
import com.aura.auracustomer.models.PaymentCalendar
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_calendar_view.*

class CalendarViewActivity : AppCompatActivity() {
    private lateinit var gridLayoutManager: GridLayoutManager

    private lateinit var slidr: SlidrInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)

        // Off screenshot
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        // Toolbar
        setSupportActionBar(calendar_toolbar as Toolbar)
        supportActionBar?.title = "Календарьный вид"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        slidr = Slidr.attach(this)

        gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        // Initialize data for recycler view
        calendarViewRecyclerView.layoutManager = gridLayoutManager
        calendarViewRecyclerView.adapter = CalendarAdapter(12)

//        calendarAdapter.setOnItemClickListener { item, _ ->
//            val calendarItem = item as PaymentCalendarItem
//            val intent = Intent(this, CalendarItemDetailsActivity::class.java)
//            intent.putExtra("data", calendarItem.item)
//            startActivity(intent)
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }
}