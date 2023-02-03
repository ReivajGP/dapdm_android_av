package com.rgp.firstpractice.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.rgp.firstpractice.R
import com.rgp.firstpractice.databinding.ActivityLyricsCatalogBinding
import com.rgp.firstpractice.helpers.AuthenticationHelper
import com.rgp.firstpractice.model.Lyrics
import com.rgp.firstpractice.model.Song
import com.rgp.firstpractice.utils.Constants
import com.rgp.firstpractice.utils.SongsAPI
import com.rgp.firstpractice.view.adapters.SongsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LyricsCatalogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLyricsCatalogBinding
    lateinit var user: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLyricsCatalogBinding.inflate(layoutInflater)
        user = intent.getStringExtra(Constants.INTENT_USER_ID).toString()
        setContentView(binding.root)
        setupView()
        setUpListeners()

        CoroutineScope(Dispatchers.IO).launch {
            val apiCall = Constants.getRetrofit().create(SongsAPI::class.java).getSongs(Constants.SONGS_LIST_EP)
            apiCall.enqueue(object: Callback<ArrayList<Song>> {
                override fun onResponse(
                    call: Call<ArrayList<Song>>,
                    response: Response<ArrayList<Song>>
                ) {
                    binding.rvCatalog.layoutManager = LinearLayoutManager(this@LyricsCatalogActivity)
                    binding.rvCatalog.adapter = SongsAdapter(this@LyricsCatalogActivity, response.body()!!)
                    binding.ivBackground.isVisible = true
                    stopLoader()
                }

                override fun onFailure(call: Call<ArrayList<Song>>, t: Throwable) {
                    Toast.makeText(this@LyricsCatalogActivity, Constants.ON_FAIL_LOADING_CATALOG_TOAST_MESSAGE, Toast.LENGTH_SHORT).show()
                    binding.ivBackground.isVisible = true
                    stopLoader()
                }
            })
        }
    }

    fun setupView() {
        launchLoader()
        binding.tvUser.text = "${Constants.USER_TEXT_VIEW_BASE_CAPTION}\n$user"
        binding.ivBackground.isVisible = false
    }

    fun setUpListeners() {
        binding.ivLogout.setOnClickListener {
            AuthenticationHelper(this).signOut {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    fun songSelected(song: Song) {
        val intent = Intent(this@LyricsCatalogActivity, LyricsDetailActivity::class.java).apply {
            putExtra(Constants.INTENT_SONG_ID, song)
        }
        startActivity(intent)
    }

    private fun launchLoader() {
        binding.laLoader.setAnimation(R.raw.book_loader)
        binding.laLoader.repeatCount = LottieDrawable.INFINITE
        binding.laLoader.playAnimation()
        binding.laLoader.speed = Constants.ANIMATION_SPEED
    }

    private fun stopLoader() {
        binding.laLoader.pauseAnimation()
        binding.laLoader.isVisible = false
    }
}