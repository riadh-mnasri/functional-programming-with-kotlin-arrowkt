package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(isEven(44))

    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)
    println(numbers.filter { numberPredicate(it) { number -> number % 2 == 0 } })

    // Lazy behaviour
    // By and Lazy keyword
    val message by lazy {
        println("My Lazy call")
        "Hello"
    }
    println(message)

    // Show Lazy Behviour
    val lazyEval = listOf({ 8 + 2 }, { 7 * 6 }, { 9 / 0 }, { 6 - 5}).asReversed()
    println(lazyEval)
    listOf(3, 4, 5).map { it + 2 }

    // Monad : Option fast Demo (map function)
   val myFirstOption: Option<String> =  "Say Hello".toOption()
    println(myFirstOption.map(String::uppercase))

    // Either: Deep Demo
    // Pattern Matching
    val result: Either<MyError, Int> = Either.Right(1)
    // Pattern Matching
    val eval = when(result){
        is Either.Left -> 0
        is Either.Right -> result.value
    }
    println(eval)

    // Function Fold
    val eval2 = result.fold(
        { 0 },
        { it + 1 }
    )
    println(eval2)
    // Either - GetOrElse: addresses Left case
    val error = MyError("Custom Error")
    val result2: Either<MyError, Int> = Either.Left(error)
    val eval3 = result2.getOrElse { 0 }
    println(eval3)
    // Map addresses Right case (transform right value if found else do nothing): Right biased
    // Either - flatMap/map - pattern
    val result4: Either<MyError, Int> = Either.Right(1)
    val result5: Either<MyError, Int> = Either.Right(2)
    val eval4 = result4.flatMap { x ->
        result5.map { y ->
            x + y
        }
    }
    // Get or Else
    println(eval4.getOrElse { 0 })
    // Validated NonEmptyList
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")

    val result3 = listOf(error1, error2).invalidNel()
    println(result3.fold({ it }, { it }))

    // Monoid - fold list
    println(listOf("functional ", "programming ", "with ", "kotlin ")
        .fold("talk: ") { a, b -> a + b })

}

fun numberPredicate(n: Int, func: (Int) -> Boolean): Boolean {
    return func(n);
}

data class MyError(val message: String)
