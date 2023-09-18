package com.example.new_kiosk

val menus: MutableList<Menu> = ArrayList()
var money: Double = 0.0
val foods: MutableList<Food> = ArrayList()
val orders: MutableList<Order> = ArrayList()
fun main() {

    kioskhello()

    while (true) {
        println("[ SHAKESHACK MENU ] \n [1] Burgers |앵거스 비프 통살을 다져만든 버거 \n [2] Forzen Custard |매장에서 신선하게 만든 아이스크림\n [3] Drinks |매장에서 직접 만드는 음료 \n [4] Beer |뉴욕 브부클린 브루어리에서 양조한 맥주 \n [5] 종료")
        val selectNumber = shakeShackMenu("selectNumber").toString().toInt()
        when (selectNumber) {
            1 -> {
                selectBurger(1)
            }
//            2 -> {
//                selectForzenCustard(2)
//            }
//            3 -> {
//                selectDrinks(3)
//            }
//            4 -> {
//                selectBeer(4)
//            }
            5 -> {
                println("키오스크 종료")
                break
            }
            else -> {
                break
            }
        }
    }
}
fun kioskhello() {
    println("SHAKESHACK BURGER 에 오신걸 환영합니다.")
    println("아래의 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
}
fun selectBurger(selectBurger: Int) {
    if (selectBurger == 1) {
//        var selectBurger = Burgers

    }
}

fun shakeShackMenu(type: String): Any? {
    return when (type) {

        "selectNumber" -> {
            println("번호를 선택해주세요.")
            while (true) {
                try {
                    var selectNumber: String? = readLine()
                    return selectNumber?.toInt() ?: -1
                } catch (e: Exception) {
                    println("번호를 다시 선택해주세요.")
                }
            }
        }
        else -> {
            return "no"
        }
    }
}
fun init() {
    money = 100.0

    // 메뉴 추가
    menus.add(Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"))
    menus.add(Menu("Forzen Custard", "매장에서 신선하기 만드는 아이스크림"))
    menus.add(Menu("Drinks", "매장에서 직접 만드는 음료"))
    menus.add(Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"))
    menus.add(Menu("Order", "장바구니를 확인 후 주문합니다."))
    menus.add(Menu("Cancel", "진행중인 주문을 취소합니다."))
}