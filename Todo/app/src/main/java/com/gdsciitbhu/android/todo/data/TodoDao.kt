package com.gdsciitbhu.android.todo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun saveTodo(todo: Todo)

    @Query("SELECT * FROM todo")
    fun getAllTodo(): LiveData<List<Todo>>

}