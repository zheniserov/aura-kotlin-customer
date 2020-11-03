package com.aura.auracustomer.views

import com.aura.auracustomer.models.Bonus

interface IBonusView : BaseView {
    fun onSuccess(bonuses: ArrayList<Bonus>)
}