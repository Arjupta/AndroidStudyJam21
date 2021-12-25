package com.gdsciitbhu.android.edictionary.data

data class ResponseModel(
    val word: String,
    val meanings: List<Meaning>
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)

data class Definition(
    val definition: String,
    val example: String? = null
)