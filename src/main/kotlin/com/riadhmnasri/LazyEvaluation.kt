package com.riadhmnasri

fun main() {
    val lazyEval = listOf({ 8 + 2 }, { 7 * 6 }, { 9 / 0 }, { 6 - 5}).asReversed()
    println(lazyEval)
    listOf(3, 4, 5).map { it + 2 }
}