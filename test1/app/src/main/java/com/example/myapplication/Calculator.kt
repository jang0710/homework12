package com.example.myapplication

class Calculator (private val operator: AbstractOperation) { // AbstractOperation을 operator로 지정해주고 (operator는 변수가 아니기에 val을 써서 고정한다.)
    fun operate (num1:Double, num2:Double): Double {
        return operator.operate(num1,num2) //AbstractOperation에서 모아준 add,sub,mul,div식을 한개의 계산식으로 압축
    }


//    fun DaddOperation(num1: ouble, num2: Double): Double { // 원래 여기서 main에 사용되는 계산식이 추가 되었는데 operate로 대체하면서 주석 처리 되었다.
//        val add = AddOperation() // add는 AddOperation 이다.
//        return add.operate(num1, num2) // 결과값
//    }
//    fun divideOperation(num1: Double,num2: Double): Double {
//        val div = DivideOperation()
//        return div.operate(num1, num2)
//    }
//
//    fun subStractOperation(num1: Double,num2: Double): Double {
//        val suv = SubStractOperation()
//        return suv.operate(num1,num2)
//    }
//    fun multiplyOperation(num1: Double, num2: Double): Double {
//        val mul = MultiplyOperation()
//        return mul.operate(num1,num2)
//    }

}