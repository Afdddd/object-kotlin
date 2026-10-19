package org.core.chapter02

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
): DefaultDiscountPolicy(conditions.toList()) {
    override fun getDiscountAmount(screening: Screening): Money = this.discountAmount
}