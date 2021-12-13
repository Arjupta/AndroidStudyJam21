package com.gdsciitbhu.android.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsciitbhu.android.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goHomeButton.setOnClickListener {
            val name = binding.name.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}