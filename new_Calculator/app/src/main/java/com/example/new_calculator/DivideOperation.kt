package com.example.new_calculator

class DivideOperation : AbstractOperation() {
   override fun operate(a: Int, b: Int): Double {
      return (a / b).toDouble()
   }
}