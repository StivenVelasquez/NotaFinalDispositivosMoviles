package com.stivenvelasquez.notafinaldispositivosmoviles.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stivenvelasquez.notafinaldispositivosmoviles.ui.main.MainActivity
import com.stivenvelasquez.notafinaldispositivosmoviles.databinding.ActivitySplashBinding
class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding : ActivitySplashBinding
    private lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        splashViewModel= ViewModelProvider(this)[SplashViewModel::class.java ]
        splashBinding =ActivitySplashBinding.inflate(layoutInflater)

        val view = splashBinding.root
        setContentView(view)

        val navigateToMainObserver = Observer<Boolean> { navigateToMain ->
            if (navigateToMain) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
        splashViewModel.navigateToMain.observe(this, navigateToMainObserver)
    }

}