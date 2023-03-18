package com.example.amphibiansapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.AmphibianInformationItem

@Composable
fun AmphibianApp(viewModel: AmphibianViewModel, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Amphibian Info") }) },
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            when (viewModel.amphibianUiState) {
                is AmphibianUiState.Success -> SuccessScreenGrid(info = (viewModel.amphibianUiState as AmphibianUiState.Success).amphibianInformation)
                is AmphibianUiState.Error -> Text(text = "Error")
                is AmphibianUiState.Loading -> Text(text = "Loading ...")
            }
        }
    }
}

@Composable
fun SuccessScreenGrid(info: List<AmphibianInformationItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        contentPadding = PaddingValues(3.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(info) { item ->
            AmphibianCard(item)
        }
    }
}

@Composable
fun AmphibianCard(info: AmphibianInformationItem, modifier: Modifier = Modifier) {
        Card(modifier = Modifier.padding(4.dp),
        elevation = 2.dp) {
            Column (modifier = Modifier.padding(8.dp)){
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(textAlign = TextAlign.Center,text = "${info.name} (${info.type})", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${info.description}", style = MaterialTheme.typography.body1, fontWeight = FontWeight.Light)
                }
                Box(modifier =Modifier.fillMaxWidth()) {
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(info.imgSrc)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        placeholder = painterResource(R.drawable.loading_img),
                        error = painterResource(R.drawable.ic_broken_image),
                        contentScale = ContentScale.FillBounds
                    )
                }

            }
        }
}
