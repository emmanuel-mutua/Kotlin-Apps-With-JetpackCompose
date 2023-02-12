package com.example.navigationdrawer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.R
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme

//sealed class DrawerScreens(val title: String, val route : String) {
//    object Home : DrawerScreens("Home", "Home")
//    object Account : DrawerScreens("Account","Account")
//    object Help : DrawerScreens("Help", "Help")
//
//}





enum class DrawerScreen(val title: String, val route: String){
    Home("Home","Home"),
    Account("Account","Account"),
    Help("Help","Help")
}
private val screens = listOf(
    DrawerScreen.Home,
    DrawerScreen.Account,
    DrawerScreen.Help
)


@Composable
fun Drawer(modifier: Modifier = Modifier, onDestinationClicked : (route : String) -> Unit) {
    Column(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(1f)
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "app icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(text = screen.title, style = MaterialTheme.typography.h4)
        }
    }
}

@Preview
@Composable
fun DrawerPrev() {
    NavigationDrawerTheme {
        //Drawer()
    }
}
