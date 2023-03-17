package com.stivenvelasquez.notafinaldispositivosmoviles.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import android.content.Intent
import com.stivenvelasquez.notafinaldispositivosmoviles.ui.main.MainActivity
import com.stivenvelasquez.notafinaldispositivosmoviles.databinding.ActivitySplashBinding
import kotlin.concurrent.timerTask


class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        splashBinding =ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(
            timerTask {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        },  2000
        )

    }

}
