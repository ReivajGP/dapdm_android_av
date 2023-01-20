package com.rgp.firstpractice.model
import com.google.gson.annotations.SerializedName

data class Song(
    var song: String? = null,
    var artist: String? = null,
    var album: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    var genre: String? = null,
    @SerializedName("song_id")
    var songId: String? = null,
    var thumbnail: String? = null
)
