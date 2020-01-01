package com.seongenie.alarmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seongenie.alarmate.sign.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginActivity = Intent(this, LoginActivity::class.java)
        startActivity(loginActivity)
    }
}
