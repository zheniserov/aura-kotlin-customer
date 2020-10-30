package com.aura.auracustomer.views

interface IAuthorizationView {
    fun onSuccess()
    fun onError(message: String)
}