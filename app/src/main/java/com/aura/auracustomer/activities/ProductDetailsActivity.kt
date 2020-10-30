package com.aura.auracustomer.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.aura.R
import com.aura.auracustomer.fragments.ProductFragment
import com.aura.auracustomer.fragments.RecommendationFragment
import com.aura.auracustomer.fragments.SellerFragment
import com.aura.auracustomer.models.Product
import com.aura.auracustomer.utils.TabLayoutFragmentAdapter
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setSupportActionBar(product_details_toolbar as Toolbar)

        val intent = intent
        val received: Product = intent.getSerializableExtra("data") as Product
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.title = received.productTitle

        // Off screenshot
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)


        val titles = ArrayList<String>()
        val fragments = ArrayList<Fragment>()

        titles.add("Товар")
        titles.add("Рекомендация")
        titles.add("Продавец")

        fragments.add(ProductFragment())
        fragments.add(RecommendationFragment())
        fragments.add(SellerFragment())

        val fragmentAdapter = TabLayoutFragmentAdapter(supportFragmentManager, fragments, titles)
        product_details_viewPager.adapter = fragmentAdapter
        product_details_tabLayout.setupWithViewPager(product_details_viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }
}