package com.example.listapp

data class CallItem(
    val aIcon: Int,
    val aName: String,
    val aPhoneNumber: String,
    val viewType: Int
) {
    companion object {
        // 꼭 const쓰지 않아도 된다. java에서는 구분을 해주어야 하지만 kotlin에서는 알아서 값을 가져 온다.
        const val VIEW_TYPE_LEFT = 0
        const val VIEW_TYPE_RIGHT = 1
    }
}