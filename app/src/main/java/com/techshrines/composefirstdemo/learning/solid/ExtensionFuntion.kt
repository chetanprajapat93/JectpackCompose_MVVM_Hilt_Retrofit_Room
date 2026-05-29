package com.asite.demopreparation

class ExtensionFuntion {

    fun main() {
        fun Int.abs(): Int{
            return if(this<0) this else 0
        }
        fun Operation.div(a: Int, b: Int){
            println("sum : ${a/b}")
        }
        println("${5.abs()}")
        
        var operation = Operation()
        operation.add(10, 5)
        operation.sub(10, 5)
        operation.multiply(10, 5)
        operation.div(10, 5)
    }
}
class Operation{
    fun add(a: Int, b: Int){
        println("sum : ${a+b}")
    }
    fun sub(a: Int, b: Int){
        println("Substraction : ${a-b}")
    }
    fun multiply(a: Int, b: Int){
        println("Multiply : ${a*b}")
    }
}

