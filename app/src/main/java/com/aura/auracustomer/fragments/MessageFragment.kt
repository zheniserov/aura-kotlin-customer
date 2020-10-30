package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.MessagesAdapter
import com.aura.auracustomer.models.Message
import com.aura.auracustomer.presenters.IMessagesPresenter
import com.aura.auracustomer.presenters.MessagesPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.views.IMessagesView
import kotlinx.android.synthetic.main.fragment_message.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MessageFragment : Fragment(), IMessagesView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var messagesPresenter: IMessagesPresenter

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

        messagesPresenter = MessagesPresenter(this)
        messagesPresenter.getAll(Constants.CUSTOMER_ID)
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
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }
}