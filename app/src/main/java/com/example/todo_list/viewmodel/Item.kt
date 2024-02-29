package com.example.todo_list.viewmodel

import com.example.todo_list.database.ItemsDbEntity

data class Item(var id: Long,
                var isDone: Boolean,
                var title: String,
                var date: String,
                var time: String,
                var details: String) {

    fun toEntity(): ItemsDbEntity = ItemsDbEntity(
        id, isDone, title, date, time, details
    )

    companion object {
        @JvmStatic
        fun fromEntity(itemEntity: ItemsDbEntity) = Item(
            itemEntity.id,
            itemEntity.isDone,
            itemEntity.title,
            itemEntity.date,
            itemEntity.time,
            itemEntity.details
        )
    }
}