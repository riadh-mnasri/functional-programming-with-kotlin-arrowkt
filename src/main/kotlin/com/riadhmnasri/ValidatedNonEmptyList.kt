package com.riadhmnasri

import arrow.core.invalidNel

fun main() {
    val error1 = IllegalStateException("error 1")
    val error2 = IllegalStateException("error 2")

    val result = listOf(error1, error2).invalidNel()
    println(result.fold({ it }, { it }))

}

