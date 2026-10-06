package org.core.chapter01

class Bag(
    private var amount: Long = 0,
    private var invitation: Invitation? = null,
    private var ticket: Ticket? = null
) {
    fun hold(ticket: Ticket): Long {
        if(hasInvitation()) {
            setTicket(ticket)
            return 0L
        } else {
            minusAmount(ticket.fee)
            setTicket(ticket)
            return ticket.fee
        }
    }

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun hasTicket(): Boolean {
        return ticket != null
    }

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}