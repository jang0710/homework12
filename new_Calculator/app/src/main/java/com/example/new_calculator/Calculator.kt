package com.example.new_calculator

class Calculator (private val operation: AbstractOperation) { //
    // operation : AbstractOperation 타입의 매개변수
    fun operate (a:Int, b:Int): Double { // a,b의 값을 입력받고
        return operation.operate(a,b) // operation에 저장된 객체의 operate 메서드를 호출한다.
    }
//    fun addOperation(a:Int, b:Int) : Double {
//        val add = AddOperation()
//        return add.operate(a,b)
//    }
//    fun subStractOperation(a: Int, b: Int) : Double {
//        val sub = SubtractOperation()
//        return sub.operate(a,b)
//    }
//    fun MultipleOperation(a: Int, b:Int) : Double {
//        val mul = MultipleOperation()
//        return mul.operate(a,b)
//    }
//    fun DivideOperation(a:Int, b:Int) : Double {
//        val div = DivideOperation()
//        return div.operate(a,b)
//    }
}