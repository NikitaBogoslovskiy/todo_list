package com.example.todo_list.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.Dependencies
import com.example.todo_list.model.custom_entities.Item
import com.example.todo_list.model.database.ItemsAppDatabase
import com.example.todo_list.model.repositories.ItemsRepository
import com.example.todo_list.viewmodel.adapter.ItemsViewAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsAppViewModel : ViewModel() {
    var itemsViewAdapter: ItemsViewAdapter
    val repository: ItemsRepository

    init {
        val itemsDao = ItemsAppDatabase.getDatabase(Dependencies.applicationContext).getItemsDao()
        repository = ItemsRepository(itemsDao)
        itemsViewAdapter = ItemsViewAdapter(repository.items)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.load()
            }
        }
    }

    fun insert(item: Item) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insert(item)
        }
    }

    fun get(id: Long) = repository.get(id)

    fun delete(id: Long) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(id)
        }
    }

    fun changeStatus(id: Long, status: Boolean) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.changeStatus(id, status)
        }
    }
}