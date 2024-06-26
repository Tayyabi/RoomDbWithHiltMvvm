package com.xyron.roomdbwithhiltmvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xyron.roomdbwithhiltmvvm.Contact

@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: ContactDao
}