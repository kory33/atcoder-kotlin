package com.github.kory33.competitive.util

private fun binarySearch(lowerBound: Long, upperBound: Long, predicate: (Long) -> Boolean): Long {
    if (upperBound == lowerBound) return lowerBound
    if (upperBound == lowerBound + 1) {
        return if (predicate(upperBound)) upperBound else lowerBound
    }
    val pivot = (lowerBound + upperBound) / 2

    return if (predicate(pivot)) binarySearch(pivot, upperBound, predicate)
    else binarySearch(lowerBound, pivot - 1, predicate)
}

private fun safeBinarySearch(lowerBound: Long, upperBound: Long, predicate: (Long) -> Boolean): Long? {
    val target =  binarySearch(lowerBound, upperBound, predicate)
    return if (predicate(target)) target else null
}