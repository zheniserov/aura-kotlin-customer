package com.aura.auracustomer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.example.aura.adapterItems.HomeProductItem
import com.example.aura.adapterItems.SliderItem
import com.aura.auracustomer.models.HomeProduct
import com.aura.auracustomer.models.Slider
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val image = "https://i.ytimg.com/vi/0t9shY1PpRs/maxresdefault.jpg"
    private val sliderAdapter = GroupAdapter<GroupieViewHolder>()
        .apply {
            add(SliderItem(Slider(image, "Акция")))
            add(SliderItem(Slider(image, "Бонус")))
            add(SliderItem(Slider(image, "Акция")))
            add(SliderItem(Slider(image, "Бонус")))
            add(SliderItem(Slider(image, "Акция")))
        }
    private val homeProductAdapter = GroupAdapter<GroupieViewHolder>()
        .apply {
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))
            add(HomeProductItem(HomeProduct(image, "Roboclean S-Plus")))

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Aura"
        fragment_home_slider_recyclerview.layoutManager = LinearLayoutManager(
            this.context,
            RecyclerView.HORIZONTAL,
            false
        )
        fragment_home_slider_recyclerview.adapter = sliderAdapter
        fragment_home_grid_recyclerview.layoutManager = GridLayoutManager(
            this.context,
            2,
            GridLayoutManager.VERTICAL,
            false
        )
        fragment_home_grid_recyclerview.adapter = homeProductAdapter

        onClickListener(ProductsFragment(), products_btn, R.id.nav_products)
        onClickListener(CommentsFragment(), comments_btn, R.id.nav_comments)
        onClickListener(PaymentsFragment(), payment_btn, R.id.nav_payments)
        onClickListener(MessageFragment(), messages_btn, R.id.nav_message)
        onClickListener(BonusesFragment(), bonuses_btn, R.id.nav_bonuses)
        onClickListener(SettingsFragment(), settings_btn, R.id.nav_settings)
        onClickListener(DefrayalFragment(), defrayal_btn, R.id.nav_defrayal)
        onClickListener(ServicesFragment(), service_btn, R.id.nav_services)


    }

    private fun onClickListener(fragment: Fragment, btn: ImageButton, id: Int) {
        btn.setOnClickListener {
            // set background color for drawer item ]<-
            (activity as MainActivity).navigation_view.setCheckedItem(id)

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}