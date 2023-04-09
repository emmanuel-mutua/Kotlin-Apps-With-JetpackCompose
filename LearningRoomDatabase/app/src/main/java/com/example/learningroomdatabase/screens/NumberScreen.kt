package com.example.learningroomdatabase.screens


import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberScreen(
    state: NumberState,
    onEvent: (NumberEvent) -> Unit,
    contacts: List<Numbers>,
    modifier: Modifier = Modifier
) {


    if (state.isAddingContact) {
        onEvent(NumberEvent.ShowDialog)
        AddNumberDialog(onEvent, state)
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
                                onClick = { onEvent(NumberEvent.SortContacts(sortTyp)) })
                            Text(text = sortTyp.name)
                        }
                    }
                }
            }

            items(contacts) { contact ->
                ContactCard(state, contact, onEvent)
            }
        }
    }
}

@Composable
fun ContactCard(
    state: NumberState,
    contact: Numbers,
    onEvent: (NumberEvent) -> Unit,
) {

    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }

    //position with no distance from the origin
    var pressOffSet by remember {
        mutableStateOf(DpOffset.Zero)
    }

    var itemHeight by remember {
        mutableStateOf(0.dp)
    }

    //clicks, drags , gestures
    var interactionSource = remember {
        MutableInteractionSource()
    }

    var density = LocalDensity.current

    val context = LocalContext.current


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            }
            .indication(interactionSource, LocalIndication.current)
            .pointerInput(true) {
                detectTapGestures(
                    onTap = {
                        isContextMenuVisible = true
                        pressOffSet = DpOffset(it.x.toDp(), it.y.toDp())
                    },
                    onPress = {
                        val press = PressInteraction.Press(it)
                        interactionSource.emit(press)
                        tryAwaitRelease()
                        interactionSource.emit(PressInteraction.Release(press))
                    }
                )
            }
            .padding(4.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(50.dp)
                    .background(color = palette.colors.random(), RoundedCornerShape(50)),
                contentAlignment = Alignment.Center

            ) {
                Text(text = "${contact.fName[0]}", color = palette1.colors.random())
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {
                Text(text = "${contact.fName} ${contact.lName}", fontSize = 20.sp)
                Text(text = "${contact.pNumber}", fontSize = 15.sp)
            }
            IconButton(onClick = { isContextMenuVisible = true }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
            }
        }

        DropdownMenu(
            expanded = isContextMenuVisible,
            offset = pressOffSet.copy(
                y = pressOffSet.y - itemHeight,
            ),
            onDismissRequest = { isContextMenuVisible = false }) {
            DropdownMenuItem(onClick = { onEvent(NumberEvent.CallNumber(contact.pNumber)) }) {
                Icon(imageVector = Icons.Default.Call, contentDescription = "Call")
            }
            DropdownMenuItem(onClick = { onEvent(NumberEvent.MessageNumber(contact.pNumber)) }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
            }
            DropdownMenuItem(onClick = { onEvent(NumberEvent.ShareNumber(contact)) }) {
                Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
            }
            DropdownMenuItem(onClick = {
                onEvent(NumberEvent.DeleteNumber(contact))
                Toast.makeText(context, "Deleted ${contact.pNumber}", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }

        }
    }
}
