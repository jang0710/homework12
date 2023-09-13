package com.example.new_calculator

fun main() {

    println("숫자를 입력하세요.")
    var a = readLine()!!.toInt()
    println("부호를 입력하세요.")
    var op = readLine()!!.toString()
    println("다음 숫자를 입력하세요.")
    var b = readLine()!!.toInt()

    val calc = Calculator()
    if (op == "+") {
        println("계산 결과는 :${calc.addOperation(a, b)}입니다.")
    } else if (op == "-") {
        println("계산 결과는${calc.subStractOperation(a,b)}입니다.")
    } else if (op == "*") {
        println("계산 결과는 ${calc.MultipleOperation(a,b)}입니다.")
    } else if (op == "/") {
        println("계산 결과는 ${calc.DivideOperation(a,b)}입니다.")
    } else {
        println("잘못된 계산입니다.")
    }
}