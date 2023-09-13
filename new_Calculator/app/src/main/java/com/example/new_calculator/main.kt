package com.example.new_calculator

fun main() {

    var a = inputMyInfo("a").toString().toInt()

    var op = inputMyInfo("c").toString()

    var b = inputMyInfo("b").toString().toInt()

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
fun inputMyInfo(type: String): Any? {
    return when (type) {
        "a" -> {
            println("숫자를 입력해 주세요.")
            while (true) {
                try {
                    var originA = readLine()
                    return originA?.toInt() ?: -1
                } catch (e: Exception) { // 모든 오류를 잡아주고 다시 입력창으로 돌려줌.
                    println("숫자를 다시 입력해 주세요.")
                }
            }
        }
        "c" -> {
            println("사칙연산을 입력해 주세요.")
            while (true) {
                try {
                    var originC = readLine()
                    if (originC?.equals("+") == true || originC?.equals("-") == true || originC?.equals("*") == true || originC?.equals("/") == true) {
                        return originC
                    } else {
                        println("다시 입력해 주세요. ex:( +, -, *, /)")
                    }
                } catch (e: Exception) {
                    println("다시 입력해 주세요. ex:( +, -, *, /)")
                }
            }
        }
        "b" -> {
            println("다음 숫자를 입력해 주세요.")
            while (true) {
                try {
                    var originB = readLine()
                    return originB?.toInt() ?: -1
                } catch (e: Exception) {
                    println("숫자를 다시 입력해 주세요.")
                }
            }
        }
        else -> {
            return "no"
        }
    }
}