package com.rgp.firstpractice.utils

import com.rgp.firstpractice.model.Lyrics
import com.rgp.firstpractice.model.Song
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface SongsAPI {
    @GET
    fun getSongs(
        @Url url: String
    ): Call<ArrayList<Song>>

    @GET
    fun getLyrics(
        @Url url: String
    ): Call<Lyrics>
}