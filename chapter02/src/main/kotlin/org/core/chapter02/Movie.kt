package org.core.chapter02

import java.time.Duration

/**
 * 다형성의 트레이드오프
 *
 * 할인정책 의존성이 없어 결합도가 낮다.
 * 새로운 할인정책이 추가되거나 수정, 삭제되도 Movie는 전혀 상관없다.
 *
 * 가독성이 떨어진다.
 * Movie 코드만 봐서는 어떤 할인정책을 사용해 할인해주는지 모른다.
 * Movie의 인스턴스를 생성하는 로직을 찾아봐야한다.
 *
 */

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy
) {
    fun getFee(): Money = fee

    /**
     * 어떤 할인 정책(일정 금액 할인, 비율 할인)으로 할인하는지 Movie는 모른다.
     * 단지 discountPolicy에게 상영 정보를 메세지로 전달할뿐.
     */

    fun calculateMovieFee(screening: Screening): Money = fee.minus(discountPolicy.calculateDiscountAmount(screening))
}