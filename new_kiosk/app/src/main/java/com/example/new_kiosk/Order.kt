package com.example.new_kiosk

class Order(food: Food) {
    var index: Int // name과 같이 식별한다.
    var food: Food
    init {
        this.index = getNextIdx()
        this.food = food
    }
    companion object {
        private var maxIdx = 1

        private fun  getNextIdx(): Int {
            return maxIdx++
        }
    }
}