package com.gdsciitbhu.android.edictionary

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.core.text.buildSpannedString
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsciitbhu.android.edictionary.data.ResponseModel
import com.gdsciitbhu.android.edictionary.data.apiService
import kotlinx.coroutines.launch

class DictionaryViewModel : ViewModel() {

    val definitionLiveData: MutableLiveData<CharSequence> = MutableLiveData("")

    fun search(word: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getMeaning(word)
                definitionLiveData.value = formatResponse(response.first())
            } catch (e: Exception) {
                definitionLiveData.value = "Word not found."
            }
        }
    }

    private fun formatResponse(response: ResponseModel): CharSequence {
        return buildSpannedString {
            response.meanings.forEach { meaning ->
                append(bold("Parts of speech: "))
                append(meaning.partOfSpeech + "\n\n")
                meaning.definitions.forEach { definition ->
                    append(bold("- Definition: "))
                    append(definition.definition)
                    if (definition.example != null) {
                        append(bold(" Ex. "))
                        append(definition.example)
                    }
                    append("\n\n")
                }
                appendLine()
            }
        }
    }

    private fun bold(s: String): SpannableString {
        val spannableString = SpannableString(s)
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            0, s.length, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }

}