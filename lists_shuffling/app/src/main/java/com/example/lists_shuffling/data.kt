package com.example.lists_shuffling

data class Emoji(
    val name: String,
    val theEmoji: String
)

val emojis = listOf(
    Emoji("Woman","👩‍🦰"),
    Emoji("Pray","🙏"),
    Emoji("Cake","🍕"),
    Emoji("Ugali","🍚"),
    Emoji("Sweet","🎂"),
    Emoji("Meat","🍗"),
    Emoji("Banana","🍌"),
    Emoji("Melon","🍉"),
    Emoji("CupCake","🧁"),
    Emoji("UMA","🍴"),
    Emoji("Smile","😁"),
    Emoji("Laugh","😂"),
    Emoji("Love","😍"),
    Emoji("Nothing","😑"),
    Emoji("Kissing","😙"),
    Emoji("Tired","😫"),

)

data class myclass(
    val name: String,
    val age : Int,
    val yr: Int
)