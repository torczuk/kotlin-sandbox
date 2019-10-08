package com.github.torczuk.sandbox.kotlin.infix


fun main() {
    listOf(1, 2).should() contain 2 contain 3 containAll listOf(1, 2) hasSize 2

    listOf(1, 2).should().contain(2)
        .contain(3)
        .containAll(1, 2)
        .hasSize(2)

    listOf(1, 2).should().sumTo(3).reduceTo(2, 1, { a, b -> a * b })
}

fun <T> List<T>.should(): ListShould<T> {
    return ListShould<T>()
}

fun <T : Number> List<T>.should(): ListNumberShould<T> {
    return ListNumberShould<T>()
}

class NumberShould<T : Number> {
    infix fun equalTo(number: T): NumberShould<T> {
        return this
    }
}

open class ListShould<T> {
    infix fun contain(element: T): ListShould<T> {
        //make some assertions
        return this
    }

    infix fun containAll(element: List<T>): ListShould<T> {
        //make some assertions
        return this
    }

    fun containAll(vararg elements: T): ListShould<T> {
        //make some assertions
        return this
    }

    infix fun hasSize(size: Int): ListShould<T> {
        //make some assertions
        return this
    }

    fun <S> reduceTo(element: T, neutral: S, reduce: (T, S) -> (S)): ListShould<T> {
        return this
    }

    fun <S> mapTo(vararg elements: S, mapper: (T, S) -> (S)): ListShould<T> {
        return this
    }

    fun containsUniqueElements(comparator: Comparator<T>): ListShould<T> {
        return this
    }
}

class ListNumberShould<T : Number> : ListShould<T>() {
    infix fun sumTo(element: T): ListNumberShould<T> {
        return this
    }

    infix fun multipleTo(element: T): ListNumberShould<T> {
        return this
    }

}