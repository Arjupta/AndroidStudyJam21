package com.gdsciitbhu.android.todo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsciitbhu.android.todo.data.Todo
import com.gdsciitbhu.android.todo.data.TodoDao
import com.gdsciitbhu.android.todo.data.TodoDatabase
import kotlinx.coroutines.launch

class ActivityViewModel : ViewModel() {

    lateinit var todoList: LiveData<List<Todo>>
    lateinit var todoDao: TodoDao

    fun init(app: Application) {
        if (::todoList.isInitialized) return
        todoDao = TodoDatabase.getTodoDatabase(app).todoDao()
        todoList = todoDao.getAllTodo()
    }

    fun saveTodo(data: String) {
        viewModelScope.launch {
            todoDao.saveTodo(Todo(data = data))
        }
    }

}