package com.xyron.roomdbwithhiltmvvm.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.xyron.roomdbwithhiltmvvm.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    //Upsert do both Insert and Update
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    suspend fun getContactsOrderByFirstName(): List<Contact>

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    suspend fun getContactsOrderByLastName(): List<Contact>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    suspend fun getContactsOrderByPhoneNumber(): List<Contact>
}