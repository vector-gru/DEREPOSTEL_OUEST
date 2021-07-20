package com.example.derepostelouest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val time : Long = 1500

        Handler().postDelayed(Runnable {
            val intent = Intent(SplashScreen@this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, time)


    }

}