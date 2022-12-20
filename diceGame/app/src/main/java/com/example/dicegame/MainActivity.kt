package com.example.dicegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicegame.ui.theme.DiceGameTheme
import rollDice
import rollNumber


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceApp()
        }
    }
}
@Composable
fun DiceApp() {
    var color = if (isSystemInDarkTheme()) {
        Color(0xFFE3E0E7)
    } else {
        Color(0xFF4406A0)
    }
    var number by remember {
        mutableStateOf(1)
    }
    var randomNum by remember {
        mutableStateOf("1")
    }
    var randomImage =
        when (number) {
            1 -> {
                R.drawable.dice_1
            }

            2 -> {
                R.drawable.dice_2
            }

            3 -> {
                R.drawable.dice_3
            }
            4 -> {
                R.drawable.dice_4
            }
            5 -> {
                R.drawable.dice_5
            }
            else -> {
                R.drawable.dice_6
            }
        }


    DiceGameTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Dice Roller",
                    color = color,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Image(painter = painterResource(id = randomImage),
                    contentDescription = "Dynamic Dice Image")
                Button(onClick = { number = rollDice() }) {
                    Text(text = "ROLL")
                }
                Row{
                    Text(text = "RandomNumber", style = MaterialTheme.typography.h5)
                }
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                Text(text = randomNum, style = MaterialTheme.typography.h4)
                    Button(onClick = { randomNum = rollNumber() }) {
                        Text(text = "Roll")
                    }
                }
            }
        }
    }
}



