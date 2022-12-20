package com.example.images

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Scaffold(
        topBar = { TopAppBarCompose() }
    ) {
        Box {
            Image(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
                painter = image, contentDescription = null, contentScale = ContentScale.Crop)
            Message()
        }
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

@Composable
fun TopAppBarCompose() {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.appbar_title),
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = { IconButton(onClick = {Toast.makeText(context, "Menu",Toast.LENGTH_SHORT).show() }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }},
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Add", Toast.LENGTH_SHORT)}) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }

            IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT) }) {
                Icon(Icons.Default.Search, contentDescription = "Add")
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Magenta
    )
}
