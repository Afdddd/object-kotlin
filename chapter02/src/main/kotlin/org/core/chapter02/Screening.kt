package org.core.chapter02

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreen: LocalDateTime,
) {
    fun getStartTime(): LocalDateTime = this.whenScreen

    fun isSequence(sequence: Int): Boolean = this.sequence == sequence

    fun getMovieFee(): Money = movie.getFee()

    private fun calculateFee(audienceCount: Int): Money =
        movie.calculateMovieFee(this).times(audienceCount.toDouble())
}