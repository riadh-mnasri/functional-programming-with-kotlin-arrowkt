package com.riadhmnasri

fun main() {
    val message by lazy {
        println("My Lazy call")
        "Hello"
    }
}