package com.aura.auracustomer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.MessagesAdapter
import com.aura.auracustomer.models.Message
import com.aura.auracustomer.presenters.IMessagePresenter
import com.aura.auracustomer.presenters.MessagePresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.views.IMessageView
import com.example.aura.R
import kotlinx.android.synthetic.main.fragment_message.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MessageFragment : Fragment(), IMessageView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var messagePresenter: IMessagePresenter

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
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Сообщения"

        messagePresenter = MessagePresenter(this, this.requireContext())
        messagePresenter.getAll(Constants.CUSTOMER_ID)

        message_swipe_refresh.setOnRefreshListener(OnRefreshListener {
            messagePresenter.getAll(Constants.CUSTOMER_ID)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onSuccess(messages: ArrayList<Message>) {
        messages_recycler_view.layoutManager = LinearLayoutManager(this.requireContext())
        messages_recycler_view.adapter = MessagesAdapter(messages)
        message_progress_bar.visibility = View.GONE
        message_swipe_refresh.isRefreshing = false
    }

    override fun onError(error: Any) {
        message_progress_bar.visibility = View.GONE
    }
}