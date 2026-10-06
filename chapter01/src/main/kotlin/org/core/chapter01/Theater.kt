package org.core.chapter01

/**
 * 개선 전
 *
 * 과한 의존성으로 인한 변경에 용이하지 못함
 * 극장이 직접 관객의 가방을 뒤져 초대장을 확인하고 매표소에서 티켓을 가져와 가방에 넣어주듯이 극장에 모든 책임이 몰림
 * 각 객체들에게 책임을 분리
 *
 * 개선 후
 *
 * 극장은 관객을 들여보내는 역할함.
 * 표를 판매하는 행위는 판매직원에게 위임
 * 이제 극장은 관객이 가방에서 돈을 꺼내든 지갑에서 돈을 꺼내든 세부사항을 알필요없어짐.
 *
 */

class Theater(
    val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}