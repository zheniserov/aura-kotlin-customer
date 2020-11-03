package com.aura.auracustomer.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.aura.auracustomer.fragments.ProductFragment
import com.aura.auracustomer.fragments.RecommendationFragment
import com.aura.auracustomer.fragments.SellerFragment
import com.aura.auracustomer.models.Product
import com.aura.auracustomer.presenters.IProductsPresenter
import com.aura.auracustomer.presenters.ProductsPresenter
import com.aura.auracustomer.utils.TabLayoutFragmentAdapter
import com.aura.auracustomer.views.IProductsView
import com.example.aura.R
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity(), IProductsView {

    private lateinit var productsPresenter: IProductsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setSupportActionBar(product_details_toolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val contractId = intent.getLongExtra("contractId", 0)

        // Off screenshot
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        productsPresenter = ProductsPresenter(this, applicationContext)
        productsPresenter.getProduct(contractId)
    }

    override fun onSuccessProduct(product: Product) {
        val titles = ArrayList<String>()
        val fragments = ArrayList<Fragment>()

        titles.add("Товар")
        titles.add("Рекомендация")
        titles.add("Продавец")

        fragments.add(ProductFragment.newInstance(product))
        fragments.add(RecommendationFragment())
        fragments.add(SellerFragment.newInstance(product))

        val fragmentAdapter = TabLayoutFragmentAdapter(supportFragmentManager, fragments, titles)
        product_details_viewPager.adapter = fragmentAdapter
        product_details_tabLayout.setupWithViewPager(product_details_viewPager)

        product_details_progress_bar.visibility = View.GONE

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed();
        }

        return true;
    }
}