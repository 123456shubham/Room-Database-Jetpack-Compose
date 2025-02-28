package com.example.roomdatatoturial.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatatoturial.data.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContractDAO
    companion object {
        var db:ContactDatabase?=null
        val DATABASE_NAME = "contact_db"

    }


}