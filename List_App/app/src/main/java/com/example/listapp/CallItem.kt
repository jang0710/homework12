package com.example.listapp

data class CallItem(
    val aIcon: Int,
    val aName: String,
    val aPhoneNumber: String,
    var isfavorite: Boolean
)
{
    companion object {
        // 꼭 const쓰지 않아도 된다. java에서는 구분을 해주어야 하지만 kotlin에서는 알아서 핟당한다. 차이점은 발생하는 오버헤드(프로그램이 실행되는 중에 다른 위치의 코드를 실행시켜야 할 때, 간접적으로 시간, 메모리, 자원 등이 사용되는 현상이다.)를 줄일수 있다는 점이다.
        const val VIEW_TYPE_LEFT = 0
        const val VIEW_TYPE_RIGHT = 1
    }
}