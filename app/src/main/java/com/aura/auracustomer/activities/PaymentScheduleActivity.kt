package com.aura.auracustomer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.example.aura.adapterItems.PaymentScheduleItem
import com.aura.auracustomer.models.PaymentSchedule
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_payment_schedule.*

class PaymentScheduleActivity : AppCompatActivity() {

    private lateinit var slidr: SlidrInterface
//    private val paymentScheduleAdapter = GroupAdapter<GroupieViewHolder>()
//        .apply {
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//            add(PaymentScheduleItem(PaymentSchedule("Дата взноса: 12.12.2002", "Сумма к оплате: 30000 тенге", "Оплачено: тенге")))
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_schedule)
        // Off screenshot
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        // Toolbar
        setSupportActionBar(payment_schedule_toolbar as Toolbar)
        supportActionBar?.title = "График платежей"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        slidr = Slidr.attach(this)

//        payment_schedule_recycler_view.layoutManager = LinearLayoutManager(this)
//        payment_schedule_recycler_view.adapter = paymentScheduleAdapter

        payment_schedule_image.visibility = View.VISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }
}