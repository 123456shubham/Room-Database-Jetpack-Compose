package com.example.roomdatatoturial.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.roomdatatoturial.data.entity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContractDAO {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Upsert
    suspend fun insertUser(contact: Contact)

    @Delete
    suspend fun deleteUser(contact: Contact)

    @Query("SELECT * FROM Contact")
     fun getAllUsers(): Flow<List<Contact>>

    @Update
    suspend fun updateUser(contact: Contact)

}