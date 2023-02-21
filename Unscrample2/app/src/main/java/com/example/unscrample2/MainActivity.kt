package com.example.unscrample2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.unscrample2.ui.theme.Unscrample2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unscrample2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ButtonSurface()
                }
            }
        }
    }
}


@Composable
fun ButtonSurface() {
    var value by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
    , verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = value, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),onValueChange = {
            if (it.contains(","))
                return@TextField
            if (it.contains(".")){return@TextField}
            if (it.contains(" "))
                return@TextField
                value = it
        })
    }
}




@Composable
fun App(
) {

    val navController = rememberNavController()
   val backStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = backStackEntry?.let {
            Screens.valueOf(
                it.id
            )
        }
    Scaffold(
        topBar = { AppBar(canNavigateBack = navController.previousBackStackEntry != null, navigateUp = {navController.navigateUp()})
        },
content = {padding -> {padding}

    NavHost(navController = navController,
        startDestination = Screens.StartScreen.name) {
        composable(route = Screens.StartScreen.name){
            StartScreen(onCLick = { navController.navigate(Screens.Game.name) })
        }

        composable(route = Screens.Game.name) {
            GameScreen()
        }
    }
}
    )

}

@Composable
fun AppBar(
    canNavigateBack: Boolean,
    navigateUp : ()->Unit) {
        TopAppBar(
            title = { Text(text = "Game")},
            modifier = Modifier,
            navigationIcon = {
                if (canNavigateBack){
                    IconButton(onClick = navigateUp) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
                    }
                }
            }
        )
}
@Composable
fun StartScreen(
    onCLick: () -> Unit
) {
    Column(
        modifier =Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onCLick) {
            Text(text = "StartGame")
        }
    }
}

//NavHost is a container that displays the current screen during navigation
//navController = responsible for navigating between destinations
//sealed class Screens(val route: String) {
//    object StartScreen: Screens("Start")
//    object Game : Screens("game")
//}




enum class Screens(){
    StartScreen,
    Game
}
