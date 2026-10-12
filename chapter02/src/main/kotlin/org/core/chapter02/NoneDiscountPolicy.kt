package org.core.chapter02

/**
 *
 * 할인 없음도 하나의 정책 객체로 표현한다.
 * 할인 금액 결정의 책임이 DiscountPolicy 계층으로 일관되게 모인다.
 */

class NoneDiscountPolicy: DiscountPolicy() {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}