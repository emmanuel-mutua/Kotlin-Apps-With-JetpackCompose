package com.example.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.model.AmphibianInformationItem
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme
import com.example.amphibiansapp.ui.theme.screens.AmphibianApp
import com.example.amphibiansapp.ui.theme.screens.AmphibianUiState
import com.example.amphibiansapp.ui.theme.screens.AmphibianViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansAppTheme {
                val viewModel : AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
                    AmphibianApp(viewModel = viewModel)
            }
        }
    }
}

