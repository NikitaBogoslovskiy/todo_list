package com.example.todo_list.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        ItemsDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getItemsDao(): ItemsDao

}