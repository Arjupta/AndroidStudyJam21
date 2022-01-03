package com.gdsciitbhu.android.todo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gdsciitbhu.android.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TodoAdapter()
        binding.todoList.adapter = adapter

        viewModel.init(application)
        viewModel.todoList.observe(this) {
            adapter.submitList(it)
        }

        binding.btnSave.setOnClickListener {
            val todo = binding.todoInput.text.toString()
            if (todo.isNotBlank())
                viewModel.saveTodo(todo)
        }
    }
}