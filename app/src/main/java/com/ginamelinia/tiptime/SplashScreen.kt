package com.ginamelinia.tiptime

import android.content.Intent
import android.os.Bundle
import android.os.HandlerThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handlerThread = HandlerThread("SplashHandlerThread")
        handlerThread.start()

        val handler = HandlerCompat.createAsync(handlerThread.looper)
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}