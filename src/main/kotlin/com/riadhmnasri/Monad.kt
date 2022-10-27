package com.riadhmnasri

interface Monad<F> {
    fun <A, B> Kind<F, A>.flatMap(f: (A) -> Kind<F, B>): Kind<F, B>
}











interface Kind<X, Y>{

}

