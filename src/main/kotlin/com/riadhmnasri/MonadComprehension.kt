package com.riadhmnasri

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.left
import arrow.core.right
import arrow.fx.IO
import arrow.fx.extensions.fx


fun main() {
    //println(getAddressFromOrder(666))
}

fun getAddressFromOrderOld(orderId: Int) =
    getOrder(orderId).flatMap { order ->
        getCustomer(order.customerId).flatMap { customer ->
            getAddress(customer.addressId)
        }
    }

/*
fun getAddressFromOrder(orderId: Int) = IO.fx {
    val order = getOrder(orderId).bind()
    val customer = getCustomer(order.customerId).bind()
    val address = getAddress(customer.addressId).bind()
    address
}
*/

/*
private fun <A, B> Either<A, B>.bind(): B {

}
*/

fun getAddress(addressId: Int): Either<Int, Address> = Address(id = 777).right()

fun getCustomer(customerId: Int): Either<Int, Customer> = Customer(addressId = 777).right()


fun getOrder(orderId: Int): Either<Int, Order> = Order(id = 666, customerId = 1234).right()

data class Order(val id: Int, val customerId: Int)

data class Customer(val addressId: Int)

data class Address(val id: Int)

