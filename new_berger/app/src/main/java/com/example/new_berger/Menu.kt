package com.example.new_berger

sealed class Menu(
    open val name: String? = null,
    open val price: Int? = null,
    open val event: String? = null
)

data class ShackBurger(
    override val name: String?,
    override val price: Int?,
    override val event: String?,

    ) : Menu()

data class CheeseBurger(
    override val name: String?,
    override val price: Int?,
) : Menu()


//fun main() {
//    val list = ArrayList<Menu>()
//    list.add(
//        ShackBurger(
//            name = "안녕 난 버거야.",
//            event = "쉑쉑~ 할인~",
//            price = 6900
//        )
//    )
//
//    list.add(
//        CheeseBurger(
//            name = "치즈버거",
//            price = 6900
//        )
//    )

//    list.forEach { menu ->
//
//
//        when (menu) {
//            is ShackBurger -> {
//                println(menu.name)
//                println(menu.event)
//                println(menu.price)
//            }
//
//            is CheeseBurger -> {
//                println(menu.name)
//                println(menu.price)
//            }
//        }
//    }
//}

