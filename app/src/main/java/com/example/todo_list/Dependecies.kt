package com.example.todo_list

import android.content.Context
import com.example.todo_list.viewmodel.ItemsAppViewModel

object Dependencies {
    lateinit var applicationContext: Context
    lateinit var itemsAppViewModel: ItemsAppViewModel

    fun init(context: Context) {
        applicationContext = context
        itemsAppViewModel = ItemsAppViewModel()
    }
}