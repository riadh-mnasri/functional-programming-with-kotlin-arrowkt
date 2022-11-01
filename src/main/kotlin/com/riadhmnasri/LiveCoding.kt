package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable
    val isEven: (Int) -> Boolean = { n -> n % 2 == 0 }
    println(isEven(44))

    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)
    println(numbers.filter { n -> numberPredicate(n) { it % 2 == 0 } })

    // Lazy behaviour
    // By and Lazy keyword
    val message by lazy {
        "Hello Kotlin"
    }

    // Show Lazy Behaviour
    val lazyEval = listOf({ 8 + 2 }, { 7 * 6 }, { 9 / 0 }, { 6 - 5 }).asReversed()
    println(lazyEval)

    // Monad : Option fast Demo (map function)
    val messageOpt = "Hello".toOption()
    println(messageOpt.map(String::uppercase).getOrElse { "Default" })

    // Either: Deep Demo
    // Pattern Matching
    val result: Either<MyError, Int> = Either.Right(1)
    // Pattern Matching
    println(
        when (result) {
            is Either.Left -> -1
            is Either.Right -> result.value
        }
    )

    // Function Fold

    // Either - GetOrElse: addresses Left case
    val error = MyError("Custom Error")
    val result2: Either<MyError, Int> = Either.Left(error)
    println(result2.getOrElse { "Default" })


    // Map addresses Right case (transform right value if found else do nothing): Right biased
    // Either - flatMap/map - pattern
    val result4: Either<MyError, Int> = Either.Right(1)
    val result5: Either<MyError, Int> = Either.Right(2)
    println(
        result4.flatMap { x ->
            result5.map { y ->
                x + y
            }
        }.getOrElse { "" }
    )

    // Validated NonEmptyList/invalidNel
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")
    val test = listOf(error1, error2).invalidNel()
    println(test.fold({ it }, { it }).flatten())

    // Monoid - fold list
    val list = listOf("Functional ", "Programming ", "With ", "Kotlin ")
    println(list.fold("Talk: ") { a, b -> a + b })

}

fun numberPredicate(n: Int, funct: (Int) -> Boolean): Boolean {
    return funct(n)
}

data class MyError(val message: String)
