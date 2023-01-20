package com.rgp.firstpractice.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    const val BASE_URL = "https://private-295f5-lyricsbook.apiary-mock.com/"  // Con el slash al final
    const val SONGS_LIST_EP = "songslist"
    const val SONGS_LYRICS_EP = "lyrics"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}