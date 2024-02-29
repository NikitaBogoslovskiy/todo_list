package com.example.todo_list.viewmodel

import com.example.todo_list.database.ItemsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemsRepository(private val itemsDao: ItemsDao) {

    fun insertNew(item: Item) {
        itemsDao.insertNew(item.toEntity())
    }

    fun getAll(): List<Item> {
        return itemsDao.getAll().map { Item.fromEntity(it) }
    }

    fun getById(itemId: Long): Item {
        return Item.fromEntity(itemsDao.getById(itemId))
    }

    fun deleteById(itemId: Long) {
        itemsDao.deleteById(itemId)
    }

    fun changeStatusById(itemId: Long, newStatus: Boolean) {
        itemsDao.changeStatusById(itemId, newStatus)
    }
}