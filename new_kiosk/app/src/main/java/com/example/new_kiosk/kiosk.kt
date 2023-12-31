package com.example.new_kiosk

import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.util.Timer
import java.util.TimerTask
import kotlin.system.exitProcess

val menus: MutableList<Menu> = ArrayList()
var money: Double = 0.0
val foods: MutableList<Food> = ArrayList()
val orders: MutableList<Order> = ArrayList()
var now = LocalDateTime.now() // 현재 시스템의 날짜와 시간을 가져온다.
var start = LocalDateTime.of(now.year, now.month, now.dayOfMonth, 1, 10, 0) // 지정된 연, 월, 일, 시, 분, 초를 기반으로한 인스턴스를 생성
var end = LocalDateTime.of(now.year, now.month, now.dayOfMonth, 1, 45, 0) // 시작시간은 1시 10분, 종료시간은 1시 45분까지

suspend fun main() { // 비동기 작업을 할 수 있게 suspend를 앞에 붙인다.
    init()

    while (true) {
        kioskMenu()
        var selectNumber = getPureNumber() // selectNumber 라는 변수로 가져와서
        if (selectNumber == 0) { // 0과 같으면
            println("3초뒤에 종료합니다.")
            globalDelay(3000) // 딜레이 3초뒤에 (비동기)
            exitProcess(0) // 종료
        }

        var selectedFood = selectMenu(selectNumber)
        globalDelay(2000) // (비동기)
        selectedFood?.let { food ->
            // selectedFood가 null이 아닐 때 수행할 코드 블록 (음식 로직)
            addOrder(food)
        } ?: run {
            println("\n현재 잔액: $money \n")
        }
    }
}
fun init() {

    print("금액을 입력해주세요.")
    money = readLine()?.toDoubleOrNull() ?: 0.0 // 값이 null이 되면 0.0을 사용한다.

    // 메뉴 추가
    menus.add(Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"))
    menus.add(Menu("Forzen Custard", "매장에서 신선하기 만드는 아이스크림"))
    menus.add(Menu("Drinks", "매장에서 직접 만드는 음료"))
    menus.add(Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"))
    menus.add(Menu("Order", "장바구니를 확인 후 주문합니다."))
    menus.add(Menu("Cancel", "진행중인 주문을 취소합니다."))

    // 버거 종류 추가
    foods.add(Food("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, "Burgers"))
    foods.add(Food("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, "Burgers"))
    foods.add(Food("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지터리안 버거", 9.4, "Burgers"))
    foods.add(Food("Cheesebuger", "포테이토 번과 비프페티, 치즈가 토핑된 치즈버거", 6.9, "Burgers"))
    foods.add(Food("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4, "Burgers"))

    // 아이스크림 종류 추가
    foods.add(Food("Plain Ice Cream", "바닐라 아이스크림", 3.0, "Forzen Custard"))
    foods.add(Food("Strawberry Ice Cream", "딸기 아이스크림", 3.5, "Forzen Custard"))
    foods.add(Food("Chocolate Ice Cream", "초콜렛 아이스크림", 3.5, "Forzen Custard"))

    // 드링크 종류 추가
    foods.add(Food("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3.9, "Drinks"))
    foods.add(Food("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks"))
    foods.add(Food("Fifty/Fifty", "상큼한 레몬에이드와 유기농 아이스티의 만남", 3.5, "Drinks"))
    foods.add(Food("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 3.3, "Drinks"))
    foods.add(Food("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks"))
    foods.add(Food("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks"))

    // 술 종류 추가
    foods.add(Food("ShackMeister Ale", "뉴욕 브부클린 브루어리에서 양조한 맥주", 9.8, "Beer"))
    foods.add(Food("Magpie Brewing Co.", "맥파이 브루잉 컴퍼니의 한국 수제 맥주의 시작", 6.8, "Beer"))

    checkOrder()

}
fun getPureNumber(): Int { // 계산기에서는 일일이 하드코딩 되어있던 a,b,c를 가져와야 했지만 함수로 만들어 넣어줌.
    var userInput: String?
    var number: Int?

    while (true) {
        print("번호를 입력해주세요.")
        userInput = readLine()
        number = userInput?.toIntOrNull() // 숫자라면 number에 넣어주고 아니면 null이 된다.

        if(number != null) { // 정수로 변환 할 수 없으면
            return number // 반환한다.
        } else {
            println("올바른 숫자를 입력해주세요.")
        }
    }
}

fun selectMenu(cateNumber: Int): Food? {
    var menu = menus[cateNumber-1] // menus 리스트에서 cateNumber -1 번째 메뉴를 가져와 변수에 넣는다.
    var categoryName = menu.name

    if (categoryName != "Order" && categoryName != "Cancel") { // Order와 Cancel 이외에
        var filteredFoods = foods.filter { it.category == categoryName } // 카테고리가 일치하면 변수에 넣는다.
        displayShakeMenuDetail(categoryName) // 해당 카테고리 메뉴를 출력하는 함수를 호출

        while (true) {
            var selectFoodNumber = getPureNumber()
            if(selectFoodNumber > filteredFoods.size || selectFoodNumber < 0) { // 0보자 작거나 없는 번호를 입력하면
                println("올바른 숫자를 입력해주세요.")
            } else if (selectFoodNumber == 0) { // 0을 입력하면
                return null // 반환
            } else {
                return filteredFoods[selectFoodNumber-1] // 그게 아니면 선택된 음식을 반환한다.
            }
        }
    } else {
        when(categoryName) {
            "Order" -> {
                val totalOrderPrice = displayOrderMenuDetail(categoryName) // 현재까지 주문한 음식들의 총 가격
                if(totalOrderPrice < 0.0 ) { // 0보다 작을 때는 주문이 없을 때 뿐
                    println("주문 내역이 존재하지 않습니다.")
                    return null
                }
                println("1. 주문\t\t 2. 메뉴판")

                while (true) {
                    var selectOrderNumber = getPureNumber() // getPureNumber() 함수에서 숫자를 입력받아서 selectOrderNumber에 저장한다.
                    when(selectOrderNumber) {
                        1 -> { // 주문을 하면
                            var isMainatainance = isMainatainance() // 함수를 호출해 현재 유지보수 상태를 확인 하고 결과를 isMainatainance에 넣는다.

                            if (isMainatainance.first) { // true 일때(시작시간과 종료시간의 밖에 있을 때)
                                println("현재 시각은 ${isMainatainance.second.hour}시 ${isMainatainance.second.minute}분입니다.")
                                println("은행 점검 시간은 ${start.hour}시 ${start.minute}분 ~ ${end.hour}시 ${end.minute}분이므로 결제할 수 없습니다.")
                            } else if (money >= totalOrderPrice) { // 잔액이 충분하면
                                orders.clear()
                                money -= totalOrderPrice
                                println("결제를 완료했습니다. ${isMainatainance.second}")
                            } else { // 잔액이 부족하면
                                println("현재 잔액은 ${money}W 으로 ${totalOrderPrice - money}W이 부족해서 주문할 수 없습니다.")
                            }
                            return null
                        }
                        2 -> { // 메뉴판으로 돌아가고 싶으면
                            println("메뉴판으로 이동합니다.")
                            return null
                        }
                        else -> {
                            println("올바른 숫자를 입력해주세요.")
                        }
                    }
                }
            }
            "Cancel" -> {
                orders.clear()
                println("메뉴판으로 이동힙니다.")
                return null
            }
            else -> {
                return null
            }
        }
    }
}
fun kioskMenu() {
    println("SHAKESHACK BURGER 에 오신걸 환영합니다.")
    println("아래의 메뉴판을 보시고 메뉴를 골라 입력해주세요.")

    val maxNameLength = menus.maxOfOrNull { it.name.length } ?: 0
    var menuSize = menus.size
    var count = 1
    for (index in 1 .. menuSize) {
        val menu = menus[index-1]
        val name = menu.name
        if (name == "Order") println("[ ORDER MENU ]")
        val desc = menu.description
        val pad = " ".repeat(maxNameLength - name.length)
        println("$index. $name$pad | $desc")
        count++
    }
    println("0. 종료 | 프로그램 종료")
}


fun displayShakeMenuDetail(categoryName: String) {

    println("\n[ $categoryName MENU ]")

    var filteredFoods = foods.filter { it.category == categoryName } // 카테고리가 같은 이름의 음식만 필터링해서 filteredFoods에 넣는다.


    val maxNameLength = filteredFoods.maxOfOrNull { it.name.length } ?: 0 // 리스트의 가장 긴 음식이름의 길이를 maxNameLength 에 넣는다.
    val maxPriceLength = filteredFoods.maxOfOrNull { it.price.toString().length } ?: 0 // 리스트의 가장 긴 가격의 길이를 maxPriceLength 에 넣는다.
    var foodSize = filteredFoods.size // 리스트(food)의 갯수를 저장한다.
    for(i in 1 .. foodSize) {
        val food = filteredFoods[i-1] // 변수에서 해당되는 인덱스의 음식을 food에 넣는다.
        val name = food.name
        val price = food.price
        val desc = food.description
        val namePadding = " ".repeat( maxNameLength - name.length) // 음식이름을 출력할 때 가장 긴 음식의 길이 만큼 공백을 넣어준다.
        val pricePadding = " ".repeat( maxPriceLength - price.toString().length) // 음식의 가격을 출력할때 가장 긴 가격의 길이만큼 공벽을 넣어준다.
        println("$i. $name$namePadding | W $price$pricePadding | $desc") // 순번에 맞게 출력
    }
    val backPadding = " ".repeat( maxNameLength - "0. 뒤로가기".length)
    println("0. 뒤로가기$backPadding | 뒤로가기")
}


fun displayOrderMenuDetail(categoryName: String): Double {
    val orderSize = orders.size
    if (orderSize > 0) { // 주문내역
        println("\n아래와 같이 주문 하시겠습니까?\n")

        println("[ Orders ]")
        for (i in 0 until orderSize) { // orderSize는 포함 시키면 안되니 util을 사용
            orders[i].food.displayInfo()
        }
        println("[ Total ]")
        val totalOrderPrice = orders.fold(0.0) { accumulator, order -> // 모든 주문의 가격을 더해 총 주문 가격을 계산
            accumulator + order.food.price // 현재까지 누적된 주문에 새로운 주문의 가격을 더해 준다.
        }
        println("W $totalOrderPrice") // 총 주문 된 가격
        return totalOrderPrice
    } else {
        return -1.0 // 주문이 들어오면 숫자가 1씩 추가 되는데 주문이 나가면 다시 1씩 깎아주는 역할
    }
}
fun addOrder(food: Food) {
    food.displayInfo()
    println("위 메뉴를 장바구니에 추가하시겠습니까?")
    println("1. 확인\t\t 2. 취소")

    while (true) {
        var selectOrderNumber = getPureNumber()
        when (selectOrderNumber) {
            1 -> {
                orders.add(Order(food))
                println("${food.name}를 장바구니에 추가했습니다.")
                return
            }
            2 -> {
                println("구매를 취소했습니다.")
                return
            }
            else -> {
                println("올바른 숫자를 입력해주세요.")
            }
        }
    }
}
suspend fun globalDelay(time: Long) {
    delay(time)
}
fun isMainatainance(): Pair<Boolean, LocalDateTime> { // 불린과 LocalDateTime 타입의 시간 정보를 반환 한다.
    var now = LocalDateTime.now() // mow에 넣음

    return Pair(now.toLocalTime() >= start.toLocalTime() && now.toLocalTime() <= end.toLocalTime(), now) // 현재시간이 시작시간과 종료시간 사이에 있는지 확인한다. 해당하면 참, 해당하지 않으면 거짓을 반환한다.(Boolean)
    // 끝에 now를 붙이는건 객체의 두번째 요소로 현재 시간을 추가 해주는 것 [결제를 완료했습니다. 2023-09-19T15:00:27.556084600]
}
fun checkOrder() {
    var timer = Timer()
    timer.schedule(object : TimerTask() {
        override fun run() {
            println("\n 현재 주문 대기수: ${orders.size}")
        }
    }, 0, 10000) // 딜레이 0, 간격 10초
}