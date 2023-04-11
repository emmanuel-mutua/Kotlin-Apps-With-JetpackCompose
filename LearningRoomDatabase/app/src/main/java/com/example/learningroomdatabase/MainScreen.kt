package com.example.learningroomdatabase


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.learningroomdatabase.bottomNavigation.BottomNav
import com.example.learningroomdatabase.bottomNavigation.BottomNavItem
import com.example.learningroomdatabase.bottomNavigation.NavigationGraph
import com.example.learningroomdatabase.screens.NumberEvent
import com.example.learningroomdatabase.screens.NumberState



@Composable
fun MainScreen(
    state : NumberState,
    onEvent : (NumberEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
    //used to observe the changes to backstackEntry and update the UI accordingly
    //navBackStackEntry contains the current screen
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    //current route use safe null operator, if it is not null then call destination then route
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        floatingActionButton = {
            if (currentRoute == "contacts"){
                FloatingActionButton(onClick = { onEvent(NumberEvent.ShowDialog) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
                }
            }
        },
        bottomBar = {
                BottomNav(navController,currentRoute)
                        },
    ) {
        paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            //the navHost
            NavigationGraph(state, onEvent, navController)
        }
    }
}