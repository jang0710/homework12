package com.example.new_kiosk

open class Menu(name: String, description: String) {
    var index: Int // 고유 넘버로 식별하게 하는 법
    var name: String
    var description: String

    init {
        this.index = getNextIdx()
        this.name = name
        this.description = description
    }
    open fun displayInfo() {
        println("ID: $index, 이름: $name, 설명: [$description]")
    }
    companion object { // 싱글턴 구조
        private var maxIdx = 1

        private fun getNextIdx(): Int {
            return maxIdx++
        }
    }

}