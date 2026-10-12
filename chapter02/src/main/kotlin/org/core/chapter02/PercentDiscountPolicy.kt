package org.core.chapter02

class PercentDiscountPolicy(
    private val percent: Double,
    private val conditions: MutableList<DiscountCondition>
): DiscountPolicy(conditions.toMutableList()) {
    override fun getDiscountAmount(screening: Screening): Money = screening.getMovieFee().times(percent)
}