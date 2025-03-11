package com.example.roomdatatoturial.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatatoturial.data.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = true, autoMigrations = [AutoMigration(from = 1, to = 2)])
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContractDAO
    companion object {
        var db:ContactDatabase?=null
        val DATABASE_NAME = "contact_db"

    }


}