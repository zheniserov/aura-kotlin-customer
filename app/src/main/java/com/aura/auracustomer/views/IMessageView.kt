package com.aura.auracustomer.views

import com.aura.auracustomer.models.Message

interface IMessageView {
    fun onSuccess(messages: ArrayList<Message>)
    fun onError(message: String)
}