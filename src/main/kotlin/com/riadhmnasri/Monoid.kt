package com.riadhmnasri

interface Monoid<A> {
    fun combine(a1: A, a2: A): A
    val nil: A
}