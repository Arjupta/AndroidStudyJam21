package com.gdsciitbhu.android.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.todo.data.Todo
import com.gdsciitbhu.android.todo.databinding.TodoListItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {

    private var todos = emptyList<Todo>()

    fun submitList(todoList: List<Todo>) {
        todos = todoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoListItemBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.todo.text = todos[position].data
    }

    override fun getItemCount() = todos.size

}

class TodoViewHolder(val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root)