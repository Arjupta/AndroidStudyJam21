package com.gdsciitbhu.android.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.todoapp.databinding.TodoListItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {

    private val todos = mutableListOf<String>()

    fun addTodo(todo: String) {
        todos.add(todo)
        notifyItemInserted(todos.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoListItemBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.todo.text = todos[position]
    }

    override fun getItemCount() = todos.size

}

class TodoViewHolder(val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root)