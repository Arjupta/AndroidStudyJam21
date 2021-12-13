package com.gdsciitbhu.android.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsciitbhu.android.todoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.helloText.text = "Hello $name!!!"

        val adapter = TodoAdapter()
        binding.todoList.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val todo = binding.todoInput.text.toString()
            if (todo.isNotBlank())
                adapter.addTodo(todo)
            binding.todoInput.setText("")
        }
    }
}