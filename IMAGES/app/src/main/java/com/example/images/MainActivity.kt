package com.example.images

import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
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
import java.lang.reflect.Modifier


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
        topBar = { TopAppBarCompose() },

        //  bottomBar = { bottomAppBarCompose() }

    ) {
        Box {

            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                painter = image, contentDescription = null, contentScale = ContentScale.Crop
            )
            Message()
        }
    }

}

@Composable
fun Message() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(R.string.happy_birthday_msg),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            text = stringResource(R.string.msg_from),
            style = MaterialTheme.typography.subtitle1,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun TopAppBarCompose() {
    val context = LocalContext.current
    var showTextField by remember {
        mutableStateOf(false)
    }
    if (!showTextField) {
        TopAppBar(
            modifier = Modifier.border(width = 0.dp, color = Color.Transparent),
            title = {
                Text(
                    text = stringResource(R.string.appbar_title),
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            elevation = 0.dp,
            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                IconButton(onClick = {
                    Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }

                IconButton(onClick = {
                    Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                    showTextField = true
                }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(onClick = {
                    Toast.makeText(context, "more", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "MoreVert")
                }
            },
            backgroundColor = Color.Transparent,
            contentColor = Color.Magenta,
        )
    } else {
        TopAppBar(modifier = Modifier.border(width = 0.dp, color = Color.Transparent),
            backgroundColor = Color.Transparent,
            elevation = 0.dp) {
            TextField(
                leadingIcon = {
                    Icon(
                        modifier = Modifier.clickable { showTextField = false },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {})
        }
    }


}


