package org.core.chapter01

class TicketOffice(
    val tickets : MutableList<Ticket>,
    var amount: Long = 0
) {

    fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}