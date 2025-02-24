package com.example.roomdatatoturial.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatatoturial.data.entity.Contact

@Dao
interface ContractDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(contact: Contact)
    @Delete
    fun deleteUser(contact: Contact)
    @Query("SELECT * FROM Contact")
    fun getAllUsers(): List<Contact>
    @Update
    fun updateUser(contact: Contact)

}