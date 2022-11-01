package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable
     

    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)

    // Lazy behaviour
    // By and Lazy keyword

    // Show Lazy Behaviour

    // Monad : Option fast Demo (map function)

    // Either: Deep Demo
    // Pattern Matching
    val result: Either<MyError, Int> = Either.Right(1)
    // Pattern Matching



    // Function Fold

    // Either - GetOrElse: addresses Left case
    val error = MyError("Custom Error")
    val result2: Either<MyError, Int> = Either.Left(error)


    // Map addresses Right case (transform right value if found else do nothing): Right biased
    // Either - flatMap/map - pattern
    val result4: Either<MyError, Int> = Either.Right(1)
    val result5: Either<MyError, Int> = Either.Right(2)

    // Validated NonEmptyList/invalidNel
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")

    // Monoid - fold list
    val list = listOf("Functional ", "Programming ", "With ", "Kotlin ")

}

data class MyError(val message: String)
