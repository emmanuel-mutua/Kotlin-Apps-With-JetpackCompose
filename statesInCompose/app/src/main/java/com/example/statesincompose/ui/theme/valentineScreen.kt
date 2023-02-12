package com.example.statesincompose.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.statesincompose.loversNames
import com.example.statesincompose.valentineQuotes

@Preview(showSystemUi = true)
@Composable
fun ValentineScreen() {

    var namesText by remember {
        mutableStateOf("")
    }
    var quotesText by remember {
        mutableStateOf("")
    }
    fun generate(){
        namesText = "I am ${loversNames.random()}"
       quotesText = valentineQuotes.random()
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "🌹", fontSize = 200.sp)
        Text(
            text = "Compose Valentine",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4
        )
        Button(onClick = { generate() }, enabled = true) {
            Text(text = "Generate")
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = namesText, fontSize = 20.sp)
               Text(text = quotesText, fontSize = 20.sp)
        }
    }
}


