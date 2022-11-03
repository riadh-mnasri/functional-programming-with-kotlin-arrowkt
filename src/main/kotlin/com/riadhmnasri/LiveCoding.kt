package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable // isEven
    val isEven: (Int) -> Boolean = { n -> n % 2 == 0 }
    println(isEven(44))

    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)
    println(numbers.filter { n -> numberPredicate(n) { x -> x % 2 == 0 } })

    // Lazy behaviour for functions
    val message by lazy {
        "Hello Kotlin"
    }
    println(message)

    // By and Lazy keyword

    // Monad : Option fast Demo (map function)
    val hello = "Hello Kotlin".toOption()
    println(hello.map(String::uppercase).getOrElse { "Default" })

    // Either: Deep Demo
    // Pattern Matching
    val result: Either<MyError, Int> = Either.Right(7)

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


    // Map addresses Right case (transform right value if found else do nothing): Right biased
    // Either - flatMap/map - pattern
    val result3: Either<MyError, Int> = Either.Right(3)
    val result4: Either<MyError, Int> = Either.Right(4)
    println(result3.flatMap { x ->
        result4.map { y ->
            x + y
        }
    })


    // Validated NonEmptyList/invalidNel/fold/flatten
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")
   val res =  listOf(error1, error2).invalidNel()
    println(res.fold({ it }, { it }).flatten())
    // Monoid - fold list


}

fun numberPredicate(n: Int, func: (Int) -> Boolean): Boolean = func(n)

data class MyError(val message: String)
