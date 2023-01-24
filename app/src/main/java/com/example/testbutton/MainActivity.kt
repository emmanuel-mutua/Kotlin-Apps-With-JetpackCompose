package com.example.testbutton

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testbutton.ui.theme.TestButtonTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestButtonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    app()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
fun app() {
    var value by remember {
        mutableStateOf("0")
    }
    var input by remember {
        mutableStateOf("")
    }
    var text = randomNumbers()
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Clicked: " + value, style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.size(10.dp))
        myButton(
            Modifier.size(200.dp), "Click", onButtonClick = {
                value = text
            }, Color = Color.LightGray
        )
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = input,
            onValueChange = { input = it },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            enabled = true,
            placeholder = {
                Text(
                    text = "Enter Value"
                )
            })
        Spacer(modifier = Modifier.size(10.dp))
//        myButton(symbol = "Display", Color = Color.LightGray, onButtonClick = {generated})
        Text(text = "Entered $input")
    }
}
