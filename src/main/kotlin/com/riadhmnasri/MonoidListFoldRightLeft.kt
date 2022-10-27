package com.riadhmnasri



fun main() {
    println(listOf("functional ", "programming ", "with ", "kotlin ")
        .fold("talk: ") { a, b -> a + b })
}
