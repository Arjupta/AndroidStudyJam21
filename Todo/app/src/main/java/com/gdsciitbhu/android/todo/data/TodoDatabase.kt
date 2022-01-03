package com.gdsciitbhu.android.todo.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        private var INSTANCE: TodoDatabase? = null
        fun getTodoDatabase(app: Application): TodoDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                app, TodoDatabase::class.java, "todo_db"
            ).build()
        }
    }

}