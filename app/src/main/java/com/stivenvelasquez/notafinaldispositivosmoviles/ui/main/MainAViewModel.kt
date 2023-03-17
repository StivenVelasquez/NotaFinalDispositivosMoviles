package com.stivenvelasquez.notafinaldispositivosmoviles.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    val labGrade: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val  firstAdvanceGrade: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val  secondAdvanceGrade: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val  finalProjectGrade: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val  notaCalculada: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun notaLab(Notalab: Double) {
        labGrade.value = Notalab
    }

    fun notaPrimerAvance(NotaPrimerAvance: Double) {
        firstAdvanceGrade.value = NotaPrimerAvance
    }

    fun notaSegundoAvance(NotaSegundoAvance: Double) {
        secondAdvanceGrade.value = NotaSegundoAvance
    }

    fun notaProyectoFinal(NotaProyectoFinal:Double) {
        finalProjectGrade.value = NotaProyectoFinal
    }

    fun notaCalculada(NotaCalculada:String) {
        notaCalculada.value =NotaCalculada
    }


    fun isValidGrade(grade: Double): Boolean {
        return grade >= 0.0 && grade <= 5.0
    }

    fun calculateWeightedAverage(labGrade: Double, firstAdvanceGrade: Double, secondAdvanceGrade: Double, finalProjectGrade: Double): Double {
        val labWeight = 0.6
        val firstAdvanceWeight = 0.07
        val secondAdvanceWeight = 0.08
        val finalProjectWeight = 0.25

        return labGrade * labWeight + firstAdvanceGrade * firstAdvanceWeight + secondAdvanceGrade * secondAdvanceWeight + finalProjectGrade * finalProjectWeight
    }


}