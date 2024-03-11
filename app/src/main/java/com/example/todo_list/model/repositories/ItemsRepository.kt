package com.example.todo_list.model.repositories

import androidx.databinding.ObservableField
import com.example.todo_list.model.custom_entities.Item
import com.example.todo_list.model.database.ItemDao
import com.example.todo_list.model.database.ItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

class ItemsRepository(private val itemDao: ItemDao) {
    private var itemsFlow: Flow<List<ItemEntity>> = itemDao.getAll()
    var items = emptyList<Item>().toMutableList()
    var overallItems = ObservableField(0)
    var checkedItems = ObservableField(0)

    suspend fun load() {
        itemsFlow.collect {
            items.clear()
            it.map { entity -> items.add(Item.fromEntity(entity)) }
            overallItems.set(items.size)
            checkedItems.set(items.filter { item -> item.isDone }.size)
        }
    }

    fun get(id: Long): Item? {
        return items.find { it.id == id }
    }

    fun insert(item: Item) {
        itemDao.insertNew(item.toEntity())
    }

    fun delete(itemId: Long) {
        itemDao.deleteById(itemId)
    }

    fun changeStatus(itemId: Long, newStatus: Boolean) {
        itemDao.changeStatusById(itemId, newStatus)
    }
}