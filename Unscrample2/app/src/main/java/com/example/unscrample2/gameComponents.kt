package com.example.unscrample2

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameStatus() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp)
            .padding(16.dp),
    ) {
        Text(text = stringResource(id = R.string.word_count, 1),fontSize = 20.sp)
        Text(modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End),text = stringResource(id = R.string.score, 10),fontSize = 20.sp)
    }
}

@Composable
fun GameLayout() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Word", fontSize = 30.sp
        )
        Text(text = stringResource(id = R.string.instructions))
        OutlinedTextField(value = "", onValueChange = {})
    }
}
