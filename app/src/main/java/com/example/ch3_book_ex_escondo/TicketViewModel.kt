package com.example.ch3_book_ex_escondo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicketViewModel: ViewModel() {
    private val _availableTickets = MutableStateFlow<Int>(10) //mutable, what we change to modify public state flow
    val availableTickets = _availableTickets.asStateFlow() //mutable, public copy

    fun purchaseTickets(tixCount: Int) {
        if (tixCount <= _availableTickets.value)
            _availableTickets.value -= tixCount
    }
}