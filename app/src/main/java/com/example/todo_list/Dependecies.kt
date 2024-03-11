package com.example.todo_list

import android.content.Context
import androidx.room.Room
import com.example.todo_list.model.database.ItemsAppDatabase
import com.example.todo_list.model.repositories.ItemsRepository
import com.example.todo_list.viewmodel.AppViewModel

object Dependencies {
    lateinit var applicationContext: Context
    lateinit var appViewModel: AppViewModel

    fun init(context: Context) {
        applicationContext = context
        appViewModel = AppViewModel()
    }
}