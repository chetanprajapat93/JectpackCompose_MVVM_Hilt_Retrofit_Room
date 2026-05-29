package com.asite.demopreparation

class KotlinLearning {
    fun printSum(sum: Int){
        println("Sum " + sum)
    }

    fun multiply(a: Int, b: Int): Int{
        return a*b;
    }

    fun highOrder(mul: (Int, Int)->Int): ((Int, Int)-> Int){
        return mul
    }

    fun highOrder(a: Int, b: Int, anyFunName: (Int)->Unit){
        var sum = a + b
        anyFunName(sum)
    }

    fun main(args: Array<String>){
        highOrder(5,10, ::printSum)
        highOrder(::multiply)
    }
}