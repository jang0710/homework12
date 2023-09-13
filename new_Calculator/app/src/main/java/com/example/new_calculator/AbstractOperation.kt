package com.example.new_calculator

abstract class AbstractOperation {
    // abstract class 클래스 이름 {
    abstract fun operate(a:Int, b:Int): Double
    // 추상 메소드(abstract method) 란 자식 클래스에서 반드시 오버라이딩 해야만 사용할 수 있는 메소드
    // abstract fun 메소드이름(변수형:자료형, 변수형2:자료형): 반환자료형
}