package com.github.torczuk.sandbox.kotlin.infix


fun main() {
    listOf(1, 2).should() contain 2 contain 3 containAll listOf(1, 2) hasSize 2
}

fun <T> List<T>.should(): ListShould<T> {
    return ListShould<T>()
}


class ListShould<T> {
    infix fun contain(element: T): ListShould<T> {
        //make some assertions
        return this
    }

    infix fun containAll(element: List<T>): ListShould<T> {
        //make some assertions
        return this
    }

    infix fun hasSize(size: Int): ListShould<T> {
        //make some assertions
        return this
    }
}