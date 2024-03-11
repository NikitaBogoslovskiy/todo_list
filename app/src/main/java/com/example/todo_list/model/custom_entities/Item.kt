package com.example.todo_list.model.custom_entities

import com.example.todo_list.model.database.ItemEntity

data class Item(var id: Long,
                var isDone: Boolean,
                var title: String,
                var date: String,
                var time: String,
                var details: String) {

    fun toEntity(): ItemEntity = ItemEntity(
        id, isDone, title, date, time, details
    )

    companion object {
        @JvmStatic
        fun fromEntity(itemEntity: ItemEntity) = Item(
            itemEntity.id,
            itemEntity.isDone,
            itemEntity.title,
            itemEntity.date,
            itemEntity.time,
            itemEntity.details
        )
    }
}