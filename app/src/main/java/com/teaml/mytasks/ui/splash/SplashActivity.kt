package com.teaml.mytasks.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teaml.mytasks.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MainActivity>()
        finish()
    }
}
