package com.example.learningroomdatabase

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface ContactsDao {
    @Upsert //if exists update if !exists add
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * from contact ORDER BY firstName ASC")
    fun getContactsOrderByFirstName(): Flow<List<Contact>>

    @Query("SELECT * from contact ORDER BY lastName ASC")
    fun getContactsOrderByLastName(): Flow<List<Contact>>
}
