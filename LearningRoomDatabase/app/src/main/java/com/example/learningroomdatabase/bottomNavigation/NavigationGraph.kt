package com.example.learningroomdatabase.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningroomdatabase.screens.*

//define your composables
@Composable
fun NavigationGraph(
    state: NumberState,
    onEvent : (NumberEvent) -> Unit,
    navController : NavHostController
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Contacts.screen_route){
        composable(BottomNavItem.Contacts.screen_route){
            NumberScreen(
                state, onEvent,state.numbers, modifier = Modifier
            )
        }
        composable(BottomNavItem.ULife.screen_route){
            ULifeScreen()
        }
        composable(BottomNavItem.Recent.screen_route){
            RecentScreen()
        }
    }
}