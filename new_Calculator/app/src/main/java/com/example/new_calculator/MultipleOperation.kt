package com.example.new_calculator

class MultipleOperation : AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a * b).toDouble()
    }

}