package org.core.chapter02

class AmountDiscountPolicy(
    private val discountAmount: Money,
    private val conditions: MutableList<DiscountCondition>
): DiscountPolicy(conditions.toMutableList()) {
    override fun getDiscountAmount(screening: Screening): Money = this.discountAmount
}