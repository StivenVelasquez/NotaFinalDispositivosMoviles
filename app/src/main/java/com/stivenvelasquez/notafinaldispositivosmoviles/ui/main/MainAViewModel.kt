package com.stivenvelasquez.notafinaldispositivosmoviles.ui.main

import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class MainViewModel : ViewModel() {

    val  weightedAverage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun calculateWeightedAverage(labGrade: Double, firstAdvanceGrade: Double, secondAdvanceGrade: Double, finalProjectGrade: Double ,
                                 linearLayout: LinearLayout){
        try {
            val labWeight = 0.6
            val firstAdvanceWeight = 0.07
            val secondAdvanceWeight = 0.08
            val finalProjectWeight = 0.25

            if (labGrade >= 0.0 && labGrade <= 5.0 && firstAdvanceGrade >= 0.0 && firstAdvanceGrade <= 5.0 && secondAdvanceGrade >= 0.0
                && secondAdvanceGrade <= 5.0 && finalProjectGrade >= 0.0 && finalProjectGrade <= 5.0
            ) {


                val grade =
                    labGrade * labWeight + firstAdvanceGrade * firstAdvanceWeight + secondAdvanceGrade * secondAdvanceWeight + finalProjectGrade * finalProjectWeight
                weightedAverage.value = (String.format("%.2f", grade))
            } else{
                weightedAverage.value = " "
                Snackbar.make(
                    linearLayout,
                    "Tiene espacios sin llenar o los datos ingresados no son válidos. Por favor verifique",
                    Snackbar.LENGTH_SHORT
                ).setAction("Aceptar") {
                }
                    .show()
            }
        }
        catch (e: NumberFormatException) {
            Snackbar.make(linearLayout, "Tiene espacios sin llenar o los datos ingresados no son válidos. Por favor verifique", Snackbar.LENGTH_SHORT)
                .setAction("Aceptar") {}
                .show()
        }
    }
}