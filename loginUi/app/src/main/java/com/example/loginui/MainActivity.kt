package com.example.loginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.ui.theme.LoginUiTheme
import com.example.loginui.ui.theme.Orange
import com.example.loginui.ui.theme.components.ButtonSurface
import com.example.loginui.ui.theme.components.PhoneField
import com.example.loginui.ui.theme.components.SignWithGoogle
import com.example.loginui.ui.theme.components.WelcomeLogin
import com.example.loginui.ui.theme.lightGray
import com.example.loginui.ui.theme.myBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
            App()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun App() {
    Column(
        modifier = Modifier.padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp).also { Arrangement.Center }) {
        WelcomeLogin()
        ButtonSurface()
        PhoneField()
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = myBlue), modifier = Modifier.width(300.dp), shape = RoundedCornerShape(30.dp)) {
            Text(text = "Send Code", fontSize = 25.sp, color = Color.White)
        }
        SignWithGoogle()

    }
}