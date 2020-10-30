package com.aura.auracustomer.views

import com.aura.auracustomer.models.Message

interface IMessagesView {
    fun onSuccess(products: ArrayList<Message>)
    fun onError(message: String)
}