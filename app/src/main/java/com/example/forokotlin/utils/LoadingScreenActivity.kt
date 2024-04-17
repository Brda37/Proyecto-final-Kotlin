package com.example.forokotlin.utils

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.R

class LoadingScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)
        Handler().postDelayed({
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }, 5000)
    }
}