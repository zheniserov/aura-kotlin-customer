package com.aura.auracustomer.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.aura.auracustomer.fragments.*
import com.example.aura.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Off screenshot
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        setSupportActionBar(toolbar as Toolbar)

        // drawer
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar as Toolbar, 0, 0
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // Intialize home fragment
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.nav_home)
        setFragment(HomeFragment())
        // -----------------------

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.user_profile -> {
                navigation_view.setCheckedItem(R.id.nav_profile)
                setFragment(ProfileFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> setFragment(HomeFragment())
            R.id.nav_profile -> setFragment(ProfileFragment())
            R.id.nav_products -> setFragment(ProductsFragment())
            R.id.nav_payments -> setFragment(PaymentsFragment())
            R.id.nav_message -> setFragment(MessageFragment())
            R.id.nav_bonuses -> setFragment(BonusesFragment())
            R.id.nav_comments -> setFragment(FeedbackFragment())
            R.id.nav_settings -> setFragment(SettingsFragment())
            R.id.nav_defrayal -> setFragment(DefrayalFragment())
            R.id.nav_services -> setFragment(ServicesFragment())
            R.id.nav_sign_out -> launchAlertDialogSignOut()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun launchAlertDialogSignOut() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure!")
        builder.setMessage("Do you want to sign out?")
        builder.setPositiveButton("Yes") { _, _ ->
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
            finish()
        }
        builder.setNegativeButton("No") { _: DialogInterface, _: Int ->

        }
        builder.show()
    }
}