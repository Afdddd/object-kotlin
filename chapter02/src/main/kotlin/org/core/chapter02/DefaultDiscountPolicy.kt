package org.core.chapter02

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>
): DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        for(each in conditions) {
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }
    protected abstract fun getDiscountAmount(screening: Screening): Money
}