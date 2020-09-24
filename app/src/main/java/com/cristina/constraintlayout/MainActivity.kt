package com.cristina.constraintlayout

import android.animation.ValueAnimator
import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mars = findViewById<ImageView>(R.id.marte)

        val animator = ValueAnimator.ofInt(0, 359)
            animator.addUpdateListener { value ->
               val animateValue = value.animatedValue as Int

                val layoutParams = mars.layoutParams as ConstraintLayout.LayoutParams
                layoutParams.circleAngle =animateValue.toFloat()

                mars.layoutParams = layoutParams
            }

        animator.repeatMode = ValueAnimator.RESTART
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 5000

        animator.start()
    }
}