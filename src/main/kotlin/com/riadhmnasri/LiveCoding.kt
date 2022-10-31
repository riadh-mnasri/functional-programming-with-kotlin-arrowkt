package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(isEven(44))


    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)
    println(numbers.filter { numberPredicate(it) { n -> n % 2 == 0 } })

    // Lazy behaviour
    // By and Lazy keyword
    val message by lazy {
        println("Hello Kotlin")
        "Hello"
    }
    println(message)

    // Show Lazy Behaviour
    val lazyEval = listOf({ 8 + 2 }, { 7 * 6 }, { 9 / 0 }, { 6 - 5 }).asReversed()
    println(lazyEval)

    // Monad : Option fast Demo (map function)
    val message2: Option<String> = "Functional Kotlin".toOption()
    Some("test")
    message2.map(String::uppercase)

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
    println(result.fold(
        { -1 },
        { it }
    ))

    // Either - GetOrElse: addresses Left case
    val error = MyError("Custom Error")
    val result2: Either<MyError, Int> = Either.Left(error)
    println(result2.getOrElse { "Default" })

    // Map addresses Right case (transform right value if found else do nothing): Right biased
    // Either - flatMap/map - pattern
    val result4: Either<MyError, Int> = Either.Right(1)
    val result5: Either<MyError, Int> = Either.Right(2)

    // Get or Else
    println(result4.flatMap { x ->
        result5.map { y ->
            x + y
        }
    })

    // Validated NonEmptyList
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")
    val result6 = listOf(error1, error2).invalidNel()
    println(result6.fold({ it }, { it }))

    // Monoid - fold list
    val list = listOf("Functional ", "Programming ", "With ", "Kotlin ")
    println(list.fold("Talk: ") { a, b-> a + b})

}

fun numberPredicate(n: Int, f: (Int) -> Boolean): Boolean {
    return f(n)
}

data class MyError(val message: String)
