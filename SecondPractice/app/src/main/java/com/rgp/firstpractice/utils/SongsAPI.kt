package com.rgp.firstpractice.utils

import com.rgp.firstpractice.model.Lyrics
import com.rgp.firstpractice.model.Song
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SongsAPI {
    @GET
    fun getSongs(
        @Url url: String
    ): Call<ArrayList<Song>>

    @GET("${Constants.BASE_URL}${Constants.SONGS_LYRICS_EP}/{${Constants.ID_PARAM_SERIALIZED_NAME}}")
    fun getLyrics(
        @Path(Constants.ID_PARAM_SERIALIZED_NAME) id: String?
    ): Call<Lyrics>
}