package com.swarn.kotlin.inline

fun main() {
    getTypeName<String>()
    getTypeName<Int>()
}

inline fun <reified T> getTypeName()  {
    println(T::class.java.simpleName)
}