package com.example.unscrample2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showSystemUi = true)
@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp).also { Arrangement.Center },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            GameStatus()
        Spacer(modifier = Modifier.height(20.dp))
            GameLayout()
            Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.skip))
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.submit))
                }
            }
    }
}


