package com.example.learningroomdatabase.screens

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Numbers(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val fName : String,
    val lName: String,
    val pNumber : String
)