package com.riadhmnasri

fun main() {
    val numbers = listOf(7, 9, 8, 5, 4, 8)
    println(numbers.filter { numberPredicate(it) { number -> number % 2 == 0 } })
}

fun numberPredicate(n: Int, func: (Int) -> Boolean): Boolean {
    return func(n);
}