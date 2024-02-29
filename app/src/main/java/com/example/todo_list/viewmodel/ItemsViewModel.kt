package com.example.todo_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ItemsViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    fun insertNew(item: Item) {
        viewModelScope.launch {
            itemsRepository.insertNew(item)
        }
    }

    fun getAll(): LiveData<List<Item>> {
        var items: List<Item> = listOf()
        runBlocking {
            withContext(Dispatchers.IO) {
                viewModelScope.launch {
                    items = itemsRepository.getAll()
                }
            }
        }
        return items
    }

    fun getById(itemId: Long): Item {
        var item: Item = Item(0, false, "", "", "", "")
        runBlocking {
            viewModelScope.launch {
                item = itemsRepository.getById(itemId)
            }
        }
        return item
    }

    fun deleteById(itemId: Long) {
        viewModelScope.launch {
            itemsRepository.deleteById(itemId)
        }
    }

    fun changeStatusById(itemId: Long, newStatus: Boolean) {
        viewModelScope.launch {
            itemsRepository.changeStatusById(itemId, newStatus)
        }
    }
}