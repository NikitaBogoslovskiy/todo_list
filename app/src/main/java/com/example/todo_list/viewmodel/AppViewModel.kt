package com.example.todo_list.viewmodel

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

class AppViewModel : ViewModel() {
    var itemsViewAdapter: ItemsViewAdapter
    private val repository: ItemsRepository

    init {
        val itemsDao = ItemsAppDatabase.getDatabase(Dependencies.applicationContext).getItemsDao()
        repository = ItemsRepository(itemsDao)
        itemsViewAdapter = ItemsViewAdapter(repository.items)
        updateUI()
    }

    private fun updateUI() = viewModelScope.launch {
            repository.update()
            itemsViewAdapter.update()
    }

    fun insert(item: Item) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insert(item)
        }
        updateUI()
    }
}