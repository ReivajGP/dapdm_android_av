package com.rgp.firstpractice.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieDrawable
import com.rgp.firstpractice.R
import com.rgp.firstpractice.databinding.ActivityLyricsDetailBinding
import com.rgp.firstpractice.model.Lyrics
import com.rgp.firstpractice.model.Song
import com.rgp.firstpractice.utils.Constants
import com.rgp.firstpractice.utils.SongsAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LyricsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityLyricsDetailBinding
    lateinit var song: Song

    @RequiresApi(33)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLyricsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        song = intent.getParcelableExtra<Song>(Constants.INTENT_SONG_ID)!!
        launchLoader()
        playLocationAnimation()

        // Set listeners
        binding.laLocation.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java).apply {
                putExtra(Constants.INTENT_ARTIST_ID, song.artist)
                putExtra(Constants.INTENT_ARTIST_ORIGIN_LATITUDE, song.artistOriginLatitude)
                putExtra(Constants.INTENT_ARTIST_ORIGIN_LONGITUDE, song.artistOriginLongitude)
            }
            startActivity(intent)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val lyricsCall = Constants.getRetrofit().create(SongsAPI::class.java).getLyrics(song.songId)
            lyricsCall.enqueue(object: Callback<Lyrics> {
                override fun onResponse(call: Call<Lyrics>, response: Response<Lyrics>) {
                    binding.tvLyrics.text = response.body()?.lyrics
                    stopLoader()
                    displayLyrics()
                }

                override fun onFailure(call: Call<Lyrics>, t: Throwable) {
                    Toast.makeText(this@LyricsDetailActivity, Constants.ON_FAIL_LOADING_LYRICS_TOAST_MESSAGE, Toast.LENGTH_SHORT).show()
                    stopLoader()
                }
            })
        }
    }

    private fun playLocationAnimation() {
        binding.laLocation.setAnimation(R.raw.location_animated)
        binding.laLocation.repeatCount = LottieDrawable.INFINITE
        binding.laLocation.playAnimation()
    }

    private fun launchLoader() {
        binding.ivLoader.setAnimation(R.raw.book_loader)
        binding.ivLoader.repeatCount = LottieDrawable.INFINITE
        binding.ivLoader.playAnimation()
        binding.ivLoader.speed = Constants.ANIMATION_SPEED
    }

    private fun stopLoader() {
        binding.ivLoader.pauseAnimation()
        binding.ivLoader.isVisible = false
    }

    private fun displayLyrics() {
        binding.tvTitle.text = song.title
        binding.tvArtist.text = song.artist
        binding.tvAlbum.text = "${getString(R.string.detail_album)}: ${song.album}"
        binding.tvReleaseDate.text = "${getString(R.string.detail_release_date)}: ${song.releaseDate}"
        binding.tvGenre.text = "${getString(R.string.detail_genre)}: ${song.genre}"
        binding.tvComposer.text = "${getString(R.string.detail_composer)}: ${song.composer}"
    }
}