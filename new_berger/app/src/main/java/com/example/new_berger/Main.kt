package com.example.new_berger

import java.lang.Exception


fun main() {
    println("메인 메뉴 입니다.")
    println("1. 햄버거, 2. 종료")

    var burgerList = ArrayList<Menu>()
    burgerList.add(
        ShackBurger(
            name = "쉑버거",
            price = 6900,
            event = "30% 할인 이벤트"
        )
    )
    burgerList.add(
        CheeseBurger(
            name = "치즈버거",
            price = 5000
        )
    )


    while (true) {
        try {
            var selectNumber = readLine()!!.toInt()

            when (selectNumber) {
                1 -> {
                    println("햄버거를 고르셨습니다.")
                    Burger(burgerList).list()
                    Burger(burgerList).burger()
                }

                2 -> {
                    println("종료합니다.")
                    System.exit(0)
                }
            }
        } catch (e: Exception) {
            println("잘못입력하였습니다.")
        }
    }
}


