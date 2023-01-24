package com.rgp.firstpractice.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    // Networking
    const val BASE_URL = "https://private-295f5-lyricsbook.apiary-mock.com/"  // Con el slash al final
    const val SONGS_LIST_EP = "songslist"
    const val SONGS_LYRICS_EP = "lyrics"

    // Splash
    const val TIMER_MILLISECONDS: Long = 3000
    const val TIMER_COUNTDOWN_INTERVAL: Long = 1000

    // Catalog
    const val ON_FAIL_LOADING_CATALOG_TOAST_MESSAGE = "IMPOSIBLE CARGAR CATÁLOGO"
    const val INTENT_SONG_ID = "Song"
    const val ANIMATION_SPEED = 2.0F

    // Details
    const val ON_FAIL_LOADING_LYRICS_TOAST_MESSAGE = "IMPOSIBLE CARGAR LETRA"

    // Song serializable ID's
    const val TITLE_SERIALIZED_NAME = "song"
    const val RELEASE_DATE_SERIALIZED_NAME = "release_date"
    const val SONG_ID_SERIALIZED_NAME = "song_id"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}