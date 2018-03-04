package com.github.kory33.competitive.util

private inline fun Pair<IntRange, IntRange>.forEach(action: (Int, Int) -> Unit)
        = first.forEachBounds({ second }, action)

private inline fun IntRange.forEachBounds(rangeGenerator: (Int) -> IntRange,
                                          action: (Int, Int) -> Unit)
        = forEach { f -> rangeGenerator(f).forEach { s -> action(f, s) } }

private fun List<IntRange>.zipWithIndices() =
        mapIndexed { first, range ->
            range.map { second -> Pair(first, second) }
        }.flatten()