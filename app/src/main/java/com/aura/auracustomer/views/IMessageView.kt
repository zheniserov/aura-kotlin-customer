package com.aura.auracustomer.views

import com.aura.auracustomer.models.Message

interface IMessageView : BaseView {
    fun onSuccess(messages: ArrayList<Message>)
}