package com.example.learningroomdatabase.screens

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NumbersDao {
    @Upsert
    suspend fun addNumber(number: Numbers)

    @Delete
    suspend fun deleteNumber(number: Numbers)

    @Query("SELECT * from numbers ORDER BY fName ASC")
     fun getNumberOrderByfName() : Flow<List<Numbers>>

    @Query("SELECT * from numbers ORDER BY lName ASC")
     fun getNumberOrderBylName() : Flow<List<Numbers>>

    @Query("SELECT * from numbers ORDER BY pNumber ASC")
     fun getNumberOrderBypNumber() : Flow<List<Numbers>>

    @Query("SELECT * from numbers WHERE fName = :query OR lName = :query OR pNumber = :query")
    fun getNumbers(query: String) : Flow<List<Numbers>>

}