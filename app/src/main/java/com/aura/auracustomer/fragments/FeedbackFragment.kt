package com.aura.auracustomer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aura.R
import com.aura.auracustomer.activities.MainActivity
import com.aura.auracustomer.adapters.FeedbackAdapter
import com.aura.auracustomer.models.Feedback
import com.aura.auracustomer.presenters.FeedbackPresenter
import com.aura.auracustomer.presenters.IFeedbackPresenter
import com.aura.auracustomer.utils.Constants
import com.aura.auracustomer.views.IFeedbackView
import kotlinx.android.synthetic.main.fragment_feedback.*

class FeedbackFragment : Fragment(), IFeedbackView {

    private lateinit var feedbackPresenter: IFeedbackPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = "Отзывы"

        feedbackPresenter = FeedbackPresenter(this, this.requireContext())
        feedbackPresenter.getFeedback(Constants.CUSTOMER_ID)
        hideProgressbar(false)
    }

    override fun onSuccess(feedback: ArrayList<Feedback>) {
        feedback_recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        feedback_recyclerView.adapter = FeedbackAdapter(feedback)
        hideProgressbar(true)
    }

    override fun onError(error: Any) {
        hideProgressbar(true)
    }

    private fun hideProgressbar(visibility: Boolean) {
        if (visibility) {
            feedback_progress_bar.visibility = View.INVISIBLE
            feedback_recyclerView.visibility = View.VISIBLE
            feedback_new_message.visibility = View.VISIBLE
        } else {
            feedback_progress_bar.visibility = View.VISIBLE
            feedback_recyclerView.visibility = View.INVISIBLE
            feedback_new_message.visibility = View.INVISIBLE
        }
    }
}