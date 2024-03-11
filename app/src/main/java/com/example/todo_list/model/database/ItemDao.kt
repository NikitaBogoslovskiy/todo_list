package com.example.todo_list.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(entity = ItemEntity::class)
    fun insertNew(item: ItemEntity)

    @Query("select t.id, t.is_done, t.title, t.date, t.time, t.details " +
            "from items t;")
    fun getAll(): Flow<List<ItemEntity>>

    @Query("select t.id, t.is_done, t.title, t.date, t.time, t.details " +
            "from items t " +
            "where t.id = :itemId;")
    fun getById(itemId: Long): Flow<ItemEntity>

    @Query("delete from items " +
            "where id = :itemId;")
    fun deleteById(itemId: Long)

    @Query("update items " +
            "set is_done = :newStatus " +
            "where id = :itemId;")
    fun changeStatusById(itemId: Long, newStatus: Boolean)
}