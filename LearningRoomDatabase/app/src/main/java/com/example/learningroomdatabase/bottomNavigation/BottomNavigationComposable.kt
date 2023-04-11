package com.example.learningroomdatabase.bottomNavigation

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController,
currentRoute :String?) {

    val items = listOf(
        BottomNavItem.Recent,
        BottomNavItem.Contacts,
        BottomNavItem.ULife,
    )

    BottomNavigation(modifier = Modifier.fillMaxWidth(),
    backgroundColor = Color.White,) {
            items.forEach{
                item ->
                BottomNavigationItem(
                    icon = {Icon(painterResource(item.icon), contentDescription = item.title)},
                    selected = currentRoute == item.screen_route,
                    alwaysShowLabel = false,
                    label = { Text(text = "${item.title}")},
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.Black.copy(0.5f),
                    onClick = {
                        navController.navigate(item.screen_route){
                            navController.graph.startDestinationRoute?.let {
                                screen_route ->
                                popUpTo(screen_route){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                interactionSource = MutableInteractionSource()
                )
            }
    }
}