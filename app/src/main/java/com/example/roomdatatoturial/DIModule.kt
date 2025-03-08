package com.example.roomdatatoturial

import android.app.Application
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.roomdatatoturial.data.database.ContactDatabase
import com.example.roomdatatoturial.data.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {
    @Provides
    @Singleton
    fun providesRepository(appDatabase: ContactDatabase): Repository {
        return Repository(appDatabase.contactDao())

    }

    @Provides
    @Singleton
    fun providesDatabase(application: Application): ContactDatabase {
      return Room.databaseBuilder(application, ContactDatabase::class.java, "contact_database.sql").build()
    }

}