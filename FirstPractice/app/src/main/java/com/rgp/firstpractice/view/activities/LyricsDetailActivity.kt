package com.rgp.firstpractice.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.firstpractice.databinding.ActivityLyricsDetailBinding

class LyricsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityLyricsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLyricsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}