package com.example.coroutines.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coroutines.R

@Composable
fun HomeScreen(modifier: Modifier,
               photoUiState: PhotosUiState) {
    when(photoUiState){
        is PhotosUiState.Success -> ResultScreen(photoUiState.photos, modifier)
        is PhotosUiState.Loading -> LoadingScreen(modifier)
        is PhotosUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun ResultScreen(
    photoUiState: String,
    modifier: Modifier
    ) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(photoUiState)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()) {
            Image(modifier = Modifier.size(150.dp),painter = painterResource(R.drawable.loading), contentDescription = "")
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center
    ,modifier = Modifier.fillMaxSize()) {
            Text(text = "Error Loading")
    }
}