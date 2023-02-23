package com.example.loginui.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.loginui.R
import androidx.compose.ui.unit.sp
import com.example.loginui.ui.theme.Orange

@Composable
fun WelcomeLogin() {
    Row(modifier = Modifier.fillMaxWidth().size(60.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Login Account", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Welcome back to account", fontWeight = FontWeight.Light, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.size(120.dp))
        IconCompination()
    }
}

@Composable
fun PhoneField() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center.also {
            Arrangement.spacedBy(20.dp)}
    ){
        Text(text = "PhoneNumber", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.size(20.dp))
        Surface(
            border = BorderStroke(1.dp, color = Color.Gray),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(40.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconCompination()
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = "| +254743411856", modifier = Modifier.padding(end = 70.dp))
                RoundIcon(ImgResource = R.drawable.veryfy)
            }
        }
    }
}

@Composable
fun SignWithGoogle() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp).also { Arrangement.Center }) {

        Text(
            text = "--- Sign With Google or Facebook ---",
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        )
        OutlinedButton(ImgResource = R.drawable.google, text = "Google")
        OutlinedButton(
            ImgResource = R.drawable.fb,
            text = "FaceBook"
        )
        Row(modifier = Modifier.padding(bottom = 30.dp)) {
            Text(text = "Don't have an account?", fontSize = 15.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Sign Up", color = Orange, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        }
    }
}