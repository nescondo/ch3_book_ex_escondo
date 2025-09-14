package com.example.ch3_book_ex_escondo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ch3_book_ex_escondo.ui.theme.Purple40
import com.example.ch3_book_ex_escondo.ui.theme.Purple80

@Composable
fun TicketScreen(vm: TicketViewModel) {
    // "by" keyword is property delegation - variables declared with this can have custom setters
    // and getters (feature only of Kotlin)
    var numTix by remember { mutableStateOf("") }
    val availableTicket by vm.availableTickets.collectAsState()
    Column(modifier = Modifier.fillMaxSize().background(color = Purple80)) {
        Text(
            text = "Available ticket ${availableTicket}",
            modifier = Modifier.padding(top = 80.dp)
        )
        OutlinedTextField(
            onValueChange = {numTix = it}, //remember, "it" is the default lambda param.
            value = numTix
        )
        Button(
            onClick = {
                vm.purchaseTickets(numTix.toInt())
            },
        ){
            Text("Buy")
        }

    }
}