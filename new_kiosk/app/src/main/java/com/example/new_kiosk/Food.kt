package com.example.new_kiosk

open class Food(name: String, description: String, price: Double, category: String): Menu(name, description) {
    var price: Double
    var category: String

    init {
        this.price = price
        this.category = category
    }

    override fun displayInfo() {
        println("이름: $name, 가격: $price, 설명: [$description]")
    }
}