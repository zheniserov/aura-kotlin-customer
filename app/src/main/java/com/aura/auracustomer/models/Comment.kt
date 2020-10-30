package com.aura.auracustomer.models


data class Comment (
    val id: Int,
    val image: String,
    val name: String,
    val text: String,
    val date: String,
    val comments: ArrayList<ChildComment>
)

data class ChildComment (
    val parent_id: Int,
    val image: String,
    val name: String,
    val text: String,
    val date: String
)
