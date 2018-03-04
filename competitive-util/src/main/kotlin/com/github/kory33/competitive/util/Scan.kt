package com.github.kory33.competitive.util

// region Scanning

private inline fun <T, R> Iterable<T>.scanIndexed(initial: R, operation: (Int, R, T) -> R): List<R>
        = foldIndexed(listOf()) { index, list, elem -> list + operation(index, list.lastOrNull() ?: initial, elem) }

private inline fun <T> Iterable<T>.scanIndexed1(operation: (Int, T, T) -> T): List<T>
        = drop(1).scanIndexed(first(), operation)

private inline fun <T, R> Iterable<T>.scan(initial: R, operation: (R, T) -> R): List<R>
        = scanIndexed(initial) {i, list, elem -> operation(list, elem) }

private inline fun <T> Iterable<T>.scan1(operation: (T, T) -> T): List<T>
        = scanIndexed1 {i, list, elem -> operation(list, elem)}

// endregion

// region Util implementations

private fun Iterable<Int>.accumulate() = this.scan(0) { a, b -> a + b }

// endregion