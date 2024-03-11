package com.example.todo_list.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        ItemEntity::class
    ]
)
abstract class ItemsAppDatabase : RoomDatabase() {
    abstract fun getItemsDao(): ItemDao

    companion object {
        @Volatile
        private var instance: ItemsAppDatabase? = null
        fun getDatabase(context: Context): ItemsAppDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsAppDatabase::class.java,
                    "items_database"
                ).build()
                instance = newInstance
                return newInstance
            }
        }
    }
}