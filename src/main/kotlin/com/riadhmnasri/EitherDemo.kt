package com.riadhmnasri

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.getOrElse

fun main() {
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
    // GetOrElse: addresses Left case
    val error = MyError("Custom Error")
    val result2: Either<MyError, Int>  = Either.Left(error)
    val eval3 = result2.getOrElse { 0 }
    println(eval3)
    // map addresses Right case (transform right value if found else do nothing): Right biased
    // flatMap
    val result4: Either<MyError, Int> = Either.Right(1)
    val result5: Either<MyError, Int> = Either.Right(2)
    val eval4 = result4.flatMap { x ->
        result5.map { y ->
            x + y
        }
    }
    println(eval4.getOrElse { 0 })

}

