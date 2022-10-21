package com.riadhmnasri

fun <T, R> List<T>.foldRight(initial: R, f: (T, R) -> R): R {
    TODO()
}

fun <T, R> List<T>.foldLeft(initial: R, f: (T, R) -> R): R {
    TODO()
}

fun <A> concatenate(la: List<A>, m: Monoid<A>): A =
    la.foldLeft(m.nil, m::combine)