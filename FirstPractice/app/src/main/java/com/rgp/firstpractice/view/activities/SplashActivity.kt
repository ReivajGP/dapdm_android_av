package com.rgp.firstpractice.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.airbnb.lottie.LottieDrawable
import com.rgp.firstpractice.R
import com.rgp.firstpractice.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startTimer()
        setAnimation()
    }

    private fun setAnimation() {
        binding.animationView.setAnimation(R.raw.book_loader)
        binding.animationView.repeatCount = LottieDrawable.INFINITE
        binding.animationView.playAnimation()
        binding.animationView.speed = 2.0F
    }

    private fun startTimer() {
        object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val intent = Intent(applicationContext, LyricsCatalogActivity::class.java).apply {}
                startActivity(intent)
            }
        }.start()
    }
}