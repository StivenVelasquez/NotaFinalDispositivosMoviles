package com.stivenvelasquez.notafinaldispositivosmoviles.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    val  weightedAverage: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    fun calculateWeightedAverage(labGrade: Double, firstAdvanceGrade: Double, secondAdvanceGrade: Double, finalProjectGrade: Double) {
        val labWeight = 0.6
        val firstAdvanceWeight = 0.07
        val secondAdvanceWeight = 0.08
        val finalProjectWeight = 0.25

        weightedAverage.value =  labGrade * labWeight + firstAdvanceGrade * firstAdvanceWeight + secondAdvanceGrade * secondAdvanceWeight + finalProjectGrade * finalProjectWeight
    }

}