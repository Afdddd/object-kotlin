package org.core.chapter02

abstract class DiscountPolicy(
    private val conditions: MutableList<DiscountCondition> = mutableListOf()
) {
    /**
     * DiscountPolicy에서 할인조건을 확인하고 세부 할인 금액 계산은 구현체에게 위임한다.
     * 이렇게 부모 클래스에서 기본적인 알고리즘 흐름을 구현하고 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 "TEMPLATE METHOD" 패턴이라 한다.
     *
     */
    fun calculateDiscountAmount(screening: Screening): Money {
       for(each in conditions) {
           if(each.isSatisfiedBy(screening)) {
               return getDiscountAmount(screening)
           }
       }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
