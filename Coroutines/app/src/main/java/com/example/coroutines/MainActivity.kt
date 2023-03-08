package com.example.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coroutines.ui.theme.CoroutinesTheme
import com.example.coroutines.ui.theme.HomeScreen

import com.example.coroutines.ui.theme.RetrofitViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesTheme {

                Surface(Modifier.fillMaxSize()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                App()
                    }
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun App() {
    val viewModel: RetrofitViewModel = viewModel()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "API PHOTOS")}) }
    ){ paddingValue ->
        HomeScreen(Modifier.padding(paddingValue), photoUiState = viewModel.photosUiState)
    }
}
