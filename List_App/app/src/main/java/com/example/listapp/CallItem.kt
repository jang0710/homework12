package com.example.listapp

data class CallItem(val aIcon:Int, val aName:String, val aPhoneNumber:String, val viewType: Int) {
    companion object {
        const val VIEW_TYPE_LEFT = 0
        const val VIEW_TYPE_RIGHT = 1
    }
}