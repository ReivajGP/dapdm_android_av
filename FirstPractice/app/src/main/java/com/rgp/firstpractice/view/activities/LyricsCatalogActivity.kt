package com.rgp.firstpractice.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.rgp.firstpractice.databinding.ActivityLyricsCatalogBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLyricsCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val apiCall = Constants.getRetrofit().create(SongsAPI::class.java).getSongs(Constants.SONGS_LIST_EP)
            apiCall.enqueue(object: Callback<ArrayList<Song>> {
                override fun onResponse(
                    call: Call<ArrayList<Song>>,
                    response: Response<ArrayList<Song>>
                ) {
                    Log.d("SONG_API", "Respuesta del servidor: ${response}")
                    Log.d("SONG_API", "Datos: ${response.body().toString()}")

                    binding.rvCatalog.layoutManager = LinearLayoutManager(this@LyricsCatalogActivity)
                    binding.rvCatalog.adapter = SongsAdapter(this@LyricsCatalogActivity, response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<Song>>, t: Throwable) {
                    Log.e("SONG_API", "ERROR: No se pudo conectar al servicio: ${t.message}")

                }
            })
        }
    }

    fun songSelected(song: Song) {
        Log.d("SONG_API", "Canción: ${song}")
        CoroutineScope(Dispatchers.IO).launch {
            val apiCall = Constants.getRetrofit().create(SongsAPI::class.java).getLyrics(Constants.SONGS_LYRICS_EP)
            apiCall.enqueue(object: Callback<Lyrics> {
                override fun onResponse(
                    call: Call<Lyrics>,
                    response: Response<Lyrics>
                ) {
                    Log.d("LYRICS_API", "Respuesta del servidor: ${response}")
                    Log.d("LYRICS_API", "Datos: ${response.body().toString()}")

                    //binding.rvCatalog.layoutManager = LinearLayoutManager(this@LyricsCatalogActivity)
                    //binding.rvCatalog.adapter = SongsAdapter(this@LyricsCatalogActivity, response.body()!!)
                }

                override fun onFailure(call: Call<Lyrics>, t: Throwable) {
                    Log.e("SONG_API", "ERROR: No se pudo conectar al servicio: ${t.message}")

                }
            })
        }

        // TODO: AQUÍ SE DEBE MANDAR A LA SIGUIENTE PANTALLA
    }
}