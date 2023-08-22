package com.example.myapplication

class AddOperation : AbstractOperation() { // AddOperation:자식 클래스 AbstractOperation: 부모 클래스
    override fun operate(num1: Double, num2: Double): Double = (num1 + num2)
    // 원래 답에는 문장의 뒷부분에 .toDouble이 붙는데 이미 파라미터 부분에 Double 처리를 하여서 사용하지 않아도 된다.
}