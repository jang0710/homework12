package com.example.myapplication

fun main() {
//    val calc = Calculator()
    println("숫자를 입력해주세요.")
    val num1 = readLine()!!.toDouble()
    println("사칙연산을 입력해주세요.")
    val op = readLine()!!.toString() // 사칙 연산 기호는 문자열 이기에 toString
    println("숫자를 입력해주세요.")
    val num2 = readLine()!!.toDouble()

    when (op) {
        "+" -> {
            val addResult = Calculator(AddOperation())
            println("답은: ${addResult.operate(num1, num2,)}입니다.") //Calcuator에서 받은 계산식이 어떤 사칙연산과 맞는지 비교
        }
        "-"-> {
            val subResult = Calculator(SubStractOperation())
            println("답은: ${subResult.operate(num1, num2)}입니다.")
        }
        "*"-> {
            val mulResult = Calculator(MultiplyOperation())
            println("답은: ${mulResult.operate(num1, num2)}입니다.")
        }
        "/"-> {
            val divResult = Calculator(DivideOperation())
            println("답은: ${divResult.operate(num1, num2)}입니다.")
        }
        else ->{
            println("잘못된 계산입니다.")
        }
    }

//    when (op) {                                   <- when 문
//        "+" -> {
//            val addResult = calc.addOperation(num1, num2)
//            println("답은 ${addResult}입니다.")
//        }
//        "/" -> {
//            val divResult = calc.divideOperation(num1, num2)
//            println("${divResult}입니다.")
//        }
//        "-" -> {
//            val subResult = calc.subStractOperation(num1, num2)
//            println("${subResult}입니다.")
//        }
//        "*" -> {
//            val mulResult = calc.multiplyOperation(num1, num2)
//            println("${mulResult}입니다.")
//        }
//    }
    //    if (op == "+") {                                <- else if 문
//        var addResult = calc.addOperation(num1,num2)
//        println("답은 ${addResult}입니다.")
//    } else if (op == "/") {
//        var divResult = calc.divideOperation(num1,num2)
//        println("${divResult}입니다.")
//    } else if (op == "*") {
//        var mulResult = calc.multiplyOperation(num1,num2)
//        println("${mulResult}입니다.")
//    } else if (op == "-") {
//        var subResult = calc.subStractOperation(num1,num2)
//        println("${subResult}입니다.")
//    }

}