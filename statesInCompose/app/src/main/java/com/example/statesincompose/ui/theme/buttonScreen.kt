package com.example.statesincompose.ui.theme

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ButtonScreen() {
    var value by remember {
        mutableStateOf("")
    }
    var output by remember {
        mutableStateOf("")
    }

    fun generate(){
        output = value
    }
    fun onValueChange(value: String){
        if (value.contains(".")){
            return
        }else{

        }


    }
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = value,placeholder = {Text(text = "Enter Value")}, onValueChange = { onValueChange(it)}, enabled = true)
        Button(onClick = { generate() }) {
            Text(text = "validate")
        }
        Text(text = output)
    }
}