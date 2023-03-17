package com.stivenvelasquez.notafinaldispositivosmoviles.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.timerTask
import java.util.Timer

class SplashViewModel : ViewModel() {

    private val _navigateToMain: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    private var timer: Timer? = null

    init {
        timer = Timer()
        timer?.schedule(timerTask {
            _navigateToMain.postValue(true)
        }, 2000)
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
        timer = null
    }
}