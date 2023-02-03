package com.rgp.firstpractice.helpers

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.rgp.firstpractice.R
import com.rgp.firstpractice.utils.Constants

class LoaderHelper(
    private val animationView: LottieAnimationView,
    private val toShowViews: Array<View>,
    private val toHideViews: Array<View>)
{
    fun presentLoader() {
        show(toShowViews)
        hide(toHideViews)
        animationView.isVisible = true
        animationView.setAnimation(R.raw.book_loader)
        animationView.repeatCount = LottieDrawable.INFINITE
        animationView.playAnimation()
        animationView.speed = Constants.ANIMATION_SPEED
    }

    fun hideLoader() {
        show(toHideViews)
        hide(toShowViews)
        animationView.isVisible = false
        animationView.pauseAnimation()
    }

    private fun show(views: Array<View>) {
        for (view in views) {
            view.isVisible = true
        }
    }

    private fun hide(views: Array<View>) {
        for (view in views) {
            view.isVisible = false
        }
    }
}