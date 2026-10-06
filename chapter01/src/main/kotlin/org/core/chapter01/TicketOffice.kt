package org.core.chapter01

class TicketOffice(
    private val tickets : MutableList<Ticket>,
    private var amount: Long = 0
) {
    fun sellTicketTo(audience: Audience) {
        val ticket = getTicket()
        val amount = audience.buy(ticket)
        plusAmount(amount)
    }

    private fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}