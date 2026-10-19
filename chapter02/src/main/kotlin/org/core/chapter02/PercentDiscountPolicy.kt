package org.core.chapter02

class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
): DefaultDiscountPolicy(conditions.toList()) {
    override fun getDiscountAmount(screening: Screening): Money = screening.getMovieFee().times(percent)
}