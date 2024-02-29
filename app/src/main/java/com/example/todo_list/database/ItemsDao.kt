package com.example.todo_list.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemsDao {
    @Insert(entity = ItemsDbEntity::class)
    fun insertNew(item: ItemsDbEntity)

    @Query("select t.id, t.is_done, t.title, t.date, t.time, t.details " +
            "from items t;")
    fun getAll(): List<ItemsDbEntity>

    @Query("select t.id, t.is_done, t.title, t.date, t.time, t.details " +
            "from items t " +
            "where t.id = :itemId;")
    fun getById(itemId: Long): ItemsDbEntity

    @Query("delete from items " +
            "where id = :itemId;")
    fun deleteById(itemId: Long)

    @Query("update items " +
            "set is_done = :newStatus " +
            "where id = :itemId;")
    fun changeStatusById(itemId: Long, newStatus: Boolean)
}