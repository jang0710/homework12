package com.example.new_berger

class OrderList {
    private val orderList = ArrayList<Menu>()
    fun addOrder(name: String, price: Int, event: String) {
        var order = ShackBurger(name, price, event)
        orderList.add(order)
        println("장바구니에 추가 되었습니다.")
    }
}