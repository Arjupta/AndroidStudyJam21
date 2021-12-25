package com.gdsciitbhu.android.edictionary.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("api/v2/entries/en/{word}")
    suspend fun getMeaning(@Path("word") word: String): List<ResponseModel>

}

val apiService: DictionaryApi by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.dictionaryapi.dev/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    retrofit.create(DictionaryApi::class.java)
}