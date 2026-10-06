package org.core.chapter01

class Bag(
    var amount: Long = 0,
    var invitation: Invitation? = null,
    var ticket: Ticket? = null
) {
    fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}