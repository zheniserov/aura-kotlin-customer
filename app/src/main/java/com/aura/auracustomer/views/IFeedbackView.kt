package com.aura.auracustomer.views

import com.aura.auracustomer.models.Feedback

interface IFeedbackView : BaseView {
    fun onSuccess(feedback: ArrayList<Feedback>)
}