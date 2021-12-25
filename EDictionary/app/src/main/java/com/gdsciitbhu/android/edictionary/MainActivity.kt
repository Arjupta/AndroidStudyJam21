package com.gdsciitbhu.android.edictionary

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gdsciitbhu.android.edictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<DictionaryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchBtn.setOnClickListener {
            val word = binding.searchText.text.toString()
            if (word.isNotBlank())
                viewModel.search(word)
        }

        viewModel.definitionLiveData.observe(this) {
            binding.definitionCard.isVisible = it.isNotEmpty()
            binding.definitionText.text = it
        }
    }
}