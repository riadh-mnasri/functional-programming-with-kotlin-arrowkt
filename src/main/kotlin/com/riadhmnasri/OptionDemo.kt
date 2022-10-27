package com.riadhmnasri

import arrow.core.Option
import arrow.core.Some

/*  sealed class Option<out T> {
    object None : Option<Nothing>() {
        override fun toString() = "None"
    }
    data class Some<out T>(val value: T) : Option<T>()
    companion object
}*/

fun main(args: Array<String>) {

    val myFirstOption: Option<String> = Some("Say Hello !")
    println(
        myFirstOption
        .map(String::uppercase)
    )
}