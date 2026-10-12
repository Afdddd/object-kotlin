package org.core.chapter02

import java.time.Duration

/**
 * 할인 정책이 없을 경우 할인 금액이 0원이라는 사실을 결정하는 책임을 Discount가 아닌 Movie에서 함
 *
 * 문제점
 * "할인 금액 결정"이라는 책임이 DiscountPolicy(정책이 있을 때)와 Movie(정책이 없을 때)로 나뉜다.
 * => "할인 유무를 로그로 남겨야한다."라는 기능이 추가되면 DiscountPolicy와 Movie 모두 수정해야한다.
 *
 * null이 퍼진다.
 * => "예상 할인액 보여주기" 같은 기능이 discountPolicy를 쓰는 다른 클래스에 생기면, 거기서 null이면 0원이라는 처리 구현해야한다.
 */

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy?
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        if(discountPolicy == null) {
            return fee
        }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }
}