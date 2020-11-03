package com.aura.auracustomer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.aura.auracustomer.adapters.PaymentScheduleAdapter
import com.aura.auracustomer.models.PaymentSchedule
import com.example.aura.R
import com.aura.auracustomer.models.Product
import com.aura.auracustomer.models.Service
import com.aura.auracustomer.presenters.IPaymentsPresenter
import com.aura.auracustomer.presenters.PaymentsPresenter
import com.aura.auracustomer.views.IPaymentsView
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_payment_schedule.*

class PaymentScheduleActivity : AppCompatActivity(), IPaymentsView {

    private lateinit var slidr: SlidrInterface
    private lateinit var paymentsPresenter: IPaymentsPresenter

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

        paymentsPresenter = PaymentsPresenter(this, applicationContext)

        // REMEMBER !!!
        // We're getting product or service
        // We're using only one in these:
        val product = intent.getSerializableExtra("product") as Product?
        val service = intent.getSerializableExtra("service") as Service?
        initData(product, service)
        hideProgressBar(false)
    }

    private fun hideProgressBar(visibility: Boolean) {
        if (visibility) {
            payment_schedule_card.visibility = View.VISIBLE
            payment_schedule_pay_btn.visibility = View.VISIBLE
            payment_schedule_recycler_view.visibility = View.VISIBLE
            payment_schedule_progress_bar.visibility = View.INVISIBLE
        } else {
            payment_schedule_card.visibility = View.INVISIBLE
            payment_schedule_pay_btn.visibility = View.INVISIBLE
            payment_schedule_recycler_view.visibility = View.INVISIBLE
            payment_schedule_progress_bar.visibility = View.VISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }

    override fun onSuccessPaymentsSchedule(paymentSchedules: ArrayList<PaymentSchedule>) {
        payment_schedule_recycler_view.layoutManager = LinearLayoutManager(this)
        payment_schedule_recycler_view.adapter = PaymentScheduleAdapter(paymentSchedules)
        hideProgressBar(true)
    }

    private fun initData(product: Product?, service: Service?) {
        val image = "https://www.rain-del-queen.co.za/images/homePage/roboclean.png"
        if (product != null) {
            paymentsPresenter.getPaymentsSchedule(product.awkey, product.bukrs)
            payment_schedule_title.text = product.matnrName
            payment_schedule_paid.text = product.paid.toString()
            payment_schedule_remainder.text = (product.price - product.paid).toString()
            payment_schedule_description.visibility = View.GONE
            Picasso.get()
                .load(image)
                .into(payment_schedule_image)
        } else if (service != null) {
            payment_schedule_image.visibility = View.INVISIBLE
            payment_schedule_title.text = "Услуга"
            payment_schedule_paid.text = "Оплачено: ${service.paid}"
            payment_schedule_remainder.text = "Остаток: ${(service.paymentDue - service.paid!!)}"
            paymentsPresenter.getPaymentsSchedule(service.awkey, service.bukrs)
            payment_schedule_description.text = "Примечание: ${service.description}"
        }
    }
}