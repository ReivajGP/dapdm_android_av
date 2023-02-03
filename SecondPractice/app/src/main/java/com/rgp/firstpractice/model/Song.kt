package com.rgp.firstpractice.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.rgp.firstpractice.utils.Constants
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(
    @SerializedName(Constants.TITLE_SERIALIZED_NAME)
    var title: String? = null,
    var artist: String? = null,
    var album: String? = null,
    @SerializedName(Constants.RELEASE_DATE_SERIALIZED_NAME)
    var releaseDate: String? = null,
    var genre: String? = null,
    var composer: String? = null,
    @SerializedName(Constants.SONG_ID_SERIALIZED_NAME)
    var songId: String? = null,
    @SerializedName(Constants.ARTIST_ORIGIN_LATITUDE_SERIALIZED_NAME)
    var artistOriginLatitude: Double? = null,
    @SerializedName(Constants.ARTIST_ORIGIN_LONGITUDE_SERIALIZED_NAME)
    var artistOriginLongitude: Double? = null,
    var thumbnail: String? = null
) : Parcelable
