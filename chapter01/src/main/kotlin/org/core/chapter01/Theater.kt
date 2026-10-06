package org.core.chapter01

/**
 * 문제 1.
 * theater는 ticketSeller와 audience의 세부적인 내용을 의존한다.
 * audience의 bag이 변경되면 theater에도 영향이간다.
 * 변경에 용이하지 못한다.
 *
 * 문제 2.
 * audience와 ticketSeller가 theater에게 통제를 받는다.
 * Theater가 직접 관객의 가방에서 초대장이 있는지 확인 -> audience.bag.hasInvitation()
 * 객체 탐색이 많아 읽기가 힘들다.
 *
 *
 * 모듈의 3가지 목적 2,3번을 만족시키지 못한다.
 *
 * 1. 제대로 동작해야한다.
 * 2. 변경에 용이해야한다. <- 문제1
 * 3. 이해하기 쉬워야 한다. <- 문제2
 */


class Theater(
    val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience) {
        if(audience.bag.hasInvitation()) {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
        } else {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.minusAmount(ticket.fee)
            ticketSeller.ticketOffice.plusAmount(ticket.fee)
            audience.bag.setTicket(ticket)
        }
    }
}