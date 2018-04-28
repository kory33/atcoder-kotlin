package com.github.kory33.competitive.util

import java.util.*

// region Scanning

private inline fun <T, R> Collection<T>.scanIndexed(initial: R, operation: (Int, R, T) -> R): List<R> {
    val result = ArrayList<R>(size)
    var prevResult = initial
    forEachIndexed { index, element ->
        val elementResult = operation(index, prevResult, element)
        result.add(elementResult)
        prevResult = elementResult
    }
    return result
}

private inline fun <T> Collection<T>.scanIndexed1(operation: (Int, T, T) -> T): List<T>
        = drop(1).scanIndexed(first(), operation)

private inline fun <T, R> Collection<T>.scan(initial: R, operation: (R, T) -> R): List<R>
        = scanIndexed(initial) {i, list, elem -> operation(list, elem) }

private inline fun <T> Collection<T>.scan1(operation: (T, T) -> T): List<T>
        = scanIndexed1 {i, list, elem -> operation(list, elem)}

// endregion

// region Util implementations

private fun Collection<Int>.accumulate() = this.scan(0) { a, b -> a + b }

// endregion