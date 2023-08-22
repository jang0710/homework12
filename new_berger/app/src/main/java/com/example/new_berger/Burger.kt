package com.example.new_berger

import java.lang.Exception

class Burger(burgerList: ArrayList<Menu>) {
    val list = burgerList


    fun list() {
        list.forEach { menu ->
            when (menu) {
                is ShackBurger -> {
                    println("[1] ${menu.name}, ${menu.price}, ${menu.event}")
                }

                is CheeseBurger -> {
                    println("[2] ${menu.name}, ${menu.price}")
                }
            }
        }
    }

    fun burger() {
        while (true) {
            try {
                var selectNumber = readLine()!!.toInt()


                when (selectNumber) {
                    1 -> {
                        println("쉑버거를 고르셨습니다.")
                        OrderList().addOrder("쉑버거", 6900, "30% 할인이벤트")
                    }

                    2 -> {
                        println("치즈버거")
                        break
                    }

                    3 -> {
                        println("돌아가기")
                        break

                    }
                }
            } catch (e: Exception) {
                println("잘못입력하셨습니다.")
            }
        }
    }
}

