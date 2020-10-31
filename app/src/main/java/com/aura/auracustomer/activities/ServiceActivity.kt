package com.aura.auracustomer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import com.aura.auracustomer.models.Service
import com.aura.auracustomer.presenters.IServicesPresenter
import com.aura.auracustomer.presenters.ServicesPresenter
import com.aura.auracustomer.views.IServicesView
import com.example.aura.R
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity(), IServicesView {

    private lateinit var slidr: SlidrInterface
    private lateinit var servicePresenter: IServicesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        // Off screenshot
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        // Toolbar
        setSupportActionBar(service_toolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Услуга"

        slidr = Slidr.attach(this)

        servicePresenter = ServicesPresenter(this)

        val serviceId = intent.getLongExtra("serviceId", 0)
        servicePresenter.getService(serviceId)
        hideProgressBar(false)

        val image = "https://www.rain-del-queen.co.za/images/homePage/roboclean.png"
        Picasso.get()
            .load(image)
            .into(service_image)
    }

    override fun onSuccessService(service: Service) {
        hideProgressBar(true)
        service_title.text = service.matnrName
        service_date_open.text = service.dateOpen
        service_payment_due.text = "Сумма: ${service.paymentDue}"
        service_description.text = "Примечание: ${service.description}"
        service_paid.text = "Задолженность: ${service.paid.toString()}"
//        service_filter_replacement.text = service.
//        service_sale_of_spare_parts.text = service.
//        service_service_package.text = service.
        service_master_name.text = "ULA, MASTER NAME NOT FOUND"
        service_master_phone_number.text = "Мобильный телефон: ${service.masterPhone}"
        service_sacked.text = if (service.sacked == 0) "Статус: Работает" else "Статус: Уволен"
    }

    private fun hideProgressBar(visibility: Boolean) {
        if (visibility) {
            service_elements.visibility = View.VISIBLE
            service_progress_bar.visibility = View.INVISIBLE
        } else {
            service_elements.visibility = View.INVISIBLE
            service_progress_bar.visibility = View.VISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }
}