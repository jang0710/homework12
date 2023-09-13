package com.example.new_calculator

class AddOperation :AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a + b).toDouble()
    }
}