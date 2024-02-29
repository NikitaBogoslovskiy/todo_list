package com.example.todo_list.view

import android.content.Context
import androidx.room.Room
import com.example.todo_list.database.AppDatabase
import com.example.todo_list.viewmodel.ItemsRepository
import com.example.todo_list.viewmodel.ItemsViewModel

object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            //.createFromAsset("room_items.db")
            .build()
    }

    private val itemsRepository: ItemsRepository by lazy { ItemsRepository(appDatabase.getItemsDao()) }
    val viewModel by lazy { ItemsViewModel(itemsRepository) }
}