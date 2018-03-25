package com.github.kory33.competitive.util

private inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }

private fun <T> List<T>.pairAdjacent() = when {
    isNotEmpty() -> {
        var prev = first()
        map { elem -> (prev to elem).also { prev = elem } }
    }
    else -> listOf()
}
