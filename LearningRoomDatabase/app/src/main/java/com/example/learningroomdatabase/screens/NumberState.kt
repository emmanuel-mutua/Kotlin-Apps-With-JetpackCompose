package com.example.learningroomdatabase.screens

data class NumberState(
    val numbers : List<Numbers> = emptyList(),
    val fName : String = "",
    val lName : String = "",
    val pNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortTyp: SortTyp = SortTyp.FIRST_NAME
)