package com.rgp.firstpractice.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.rgp.firstpractice.databinding.ActivitySplashBinding
import com.rgp.firstpractice.utils.Constants

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startTimer()
    }

    private fun startTimer() {
        object: CountDownTimer(Constants.TIMER_MILLISECONDS, Constants.TIMER_COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val intent = Intent(applicationContext, LyricsCatalogActivity::class.java).apply {}
                finish()
                startActivity(intent)
            }
        }.start()
    }
}