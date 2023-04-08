package com.example.learningroomdatabase.screens

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Numbers :: class],
    version = 2
)
abstract class NumbersDatabase : RoomDatabase() {
    abstract val numbersDao: NumbersDao
}