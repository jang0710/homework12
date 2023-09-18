package com.example.new_kiosk

open class Menu(name: String, description: String) {
    var index: Int
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
    companion object {
        private var maxIdx = 1

        private fun getNextIdx(): Int {
            return maxIdx++
        }
    }

}