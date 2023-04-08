package com.example.learningroomdatabase.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberScreen(
    state: NumberState,
    onEvent: (NumberEvent) -> Unit,
    modifier: Modifier = Modifier
) {


    if (state.isAddingContact) {
        onEvent(NumberEvent.ShowDialog)
        AddNumberDialog(onEvent,state)
    }
    Scaffold(
        modifier.padding(10.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(NumberEvent.ShowDialog) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {
                    SortTyp.values().forEach { sortTyp ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable { onEvent(NumberEvent.SortContacts(sortTyp)) }) {
                            RadioButton(
                                selected = state.sortTyp == sortTyp,
                                onClick = {  onEvent(NumberEvent.SortContacts(sortTyp)) })
                            Text(text = sortTyp.name)
                        }
                    }
                }
            }

            items(state.numbers) { contact ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "${contact.fName} ${contact.lName}", fontSize = 20.sp)
                        Text(text = "${contact.pNumber}", fontSize = 15.sp)
                    }
                    IconButton(onClick = { onEvent(NumberEvent.DeleteNumber(contact)) }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Contact")
                    }
                }
            }
        }
    }
}