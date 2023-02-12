package com.example.testbutton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun myButton(
    modifier: Modifier = Modifier,
    symbol: String,
    onButtonClick: () -> Unit = {},
    Color : Color
) {
    Surface(
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
            .clickable { onButtonClick.invoke()},
        color = Color,
        elevation = 0.dp,
        shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = symbol)
        }
    }
}

fun randomNumbers(): String{
    while (true) {
        return listOf(1, 2, 3, 4, 5, 6).random().toString()
    }
}