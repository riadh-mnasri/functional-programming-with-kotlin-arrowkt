package com.riadhmnasri

import arrow.core.*

fun main() {
    // First citizen functions
    // Declare Function and set it to variable


    // Pass function numberPredicate to function
    val numbers = listOf(7, 9, 8, 5, 4, 8)

    // Lazy behaviour
    // By and Lazy keyword


    // Show Lazy Behviour

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

    // Get or Else


    // Validated NonEmptyList
    val error1 = MyError("error 1")
    val error2 = MyError("error 2")

    // Monoid - fold list


}

data class MyError(val message: String)
