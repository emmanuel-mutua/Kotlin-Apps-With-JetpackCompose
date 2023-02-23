package com.example.statesincompose.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun TipCalculator() {
    var value by remember {
        mutableStateOf("")
    }

    var output by remember {
        mutableStateOf("")
    }


    fun calculate(utput: Double) {
        output = (utput * 15 / 100).toString()
    }


    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val char = listOf(",","-"," ", "+")
        Text(text = "Tip Calculator, 15%", style = MaterialTheme.typography.h4)
        TextField(
            value = value,
            onValueChange = {
                if (!it.matches(Regex("^[0-9]*\\.?[0-9]{0,3} \$")) && it.contains(".") && it.matches(Regex("^'-'+ ',' + ' '\$"))) {
                    return@TextField
                }

                value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Button(onClick = {
            if (value.isNotEmpty()) {
                calculate(value.toDouble())
            }
        }) {
            Text(text = "Calculate")
        }
        Text(text = output)
    }
}

