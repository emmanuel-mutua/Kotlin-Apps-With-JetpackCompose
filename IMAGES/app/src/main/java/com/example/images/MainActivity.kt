package com.example.images

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.images.ui.theme.IMAGESTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyApp() {
    val image = painterResource(id = R.drawable.br)
    Box {
        Image(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        Message()
    }
}

@Composable
fun Message() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text(
            text = stringResource(R.string.happy_birthday_msg),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold)
        Text(modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top = 10.dp),
            text = stringResource(R.string.msg_from),
            style = MaterialTheme.typography.subtitle1,
            fontStyle = FontStyle.Italic)
    }
}
