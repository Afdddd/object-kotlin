package org.core.chapter02

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}