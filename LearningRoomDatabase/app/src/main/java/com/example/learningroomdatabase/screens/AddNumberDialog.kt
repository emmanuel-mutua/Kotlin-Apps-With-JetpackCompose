package com.example.learningroomdatabase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddNumberDialog(
    onEvent: (NumberEvent) -> Unit,
    state: NumberState
) {
    AlertDialog(
        title = { Text(text = "Add Contact") },
        onDismissRequest = { onEvent(NumberEvent.HideDialog) },
        buttons = {
            Box(modifier = Modifier
                .padding(4.dp), contentAlignment = Alignment.TopEnd
            ) {
                Button(onClick = { onEvent(NumberEvent.SaveNumber) }) {
                    Text(text = "Save")
                }
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(
                    value = state.fName,
                    onValueChange = {
                        onEvent(NumberEvent.SetFirstName(it))
                                    },
                placeholder = { Text(text = "FirstName")}
                )
                TextField(
                    value = state.lName,
                    onValueChange = {
                        onEvent(NumberEvent.SetLastName(it))
                    },
                    placeholder = { Text(text = "LastName")}
                )
                TextField(
                    value = state.pNumber,
                    onValueChange = {
                        onEvent(NumberEvent.SetPhoneNumber(it))
                    },
                    placeholder = { Text(text = "PhoneNumber")}
                )
            }
        })
}