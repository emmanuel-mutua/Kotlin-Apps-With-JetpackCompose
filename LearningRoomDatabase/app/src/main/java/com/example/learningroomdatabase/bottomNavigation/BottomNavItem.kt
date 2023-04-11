package com.example.learningroomdatabase.bottomNavigation

import com.example.learningroomdatabase.R

sealed class BottomNavItem(
    val title : String,
    val icon : Int,
    val screen_route :String
) {
        object Recent: BottomNavItem("Recent", R.drawable.recent,"recent")
        object Contacts: BottomNavItem("Contacts",R.drawable.contact,"contacts")
        object ULife: BottomNavItem("ULife",R.drawable.heart,"uLife")
}