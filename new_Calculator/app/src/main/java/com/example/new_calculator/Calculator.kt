package com.example.new_calculator

class Calculator {
    fun addOperation(a:Int, b:Int) : Double {
        val add = AddOperation()
        return add.operate(a,b)
    }
    fun subStractOperation(a: Int, b: Int) : Double {
        val sub = SubtractOperation()
        return sub.operate(a,b)
    }
    fun MultipleOperation(a: Int, b:Int) : Double {
        val mul = MultipleOperation()
        return mul.operate(a,b)
    }
    fun DivideOperation(a:Int, b:Int) : Double {
        val div = DivideOperation()
        return div.operate(a,b)
    }
}