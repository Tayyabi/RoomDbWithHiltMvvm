package com.xyron.roomdbwithhiltmvvm.di

import android.content.Context
import androidx.room.Room
import com.xyron.roomdbwithhiltmvvm.db.ContactDao
import com.xyron.roomdbwithhiltmvvm.db.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideContactDB(@ApplicationContext context: Context) : ContactDatabase {
        return Room.databaseBuilder(
            context,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()
    }

    @Provides
    fun provideUserDao(database: ContactDatabase): ContactDao {
        return database.dao
    }
}