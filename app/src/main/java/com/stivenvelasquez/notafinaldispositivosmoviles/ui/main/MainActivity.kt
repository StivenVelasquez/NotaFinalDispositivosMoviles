package com.stivenvelasquez.notafinaldispositivosmoviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.stivenvelasquez.notafinaldispositivosmoviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding =ActivityMainBinding.inflate(layoutInflater)
        val view =mainBinding.root
        setContentView(view)

        //Botón de calcular la nota
        mainBinding.calculateNoteButton.setOnClickListener {
            try {
                val labGrade = mainBinding.notaLabEditText.text.toString().toDouble()
                val firstAdvanceGrade = mainBinding.notaPrimerAvanceEditText.text.toString().toDouble()
                val secondAdvanceGrade = mainBinding.notaSegundoAvanceEditText.text.toString().toDouble()
                val finalProjectGrade = mainBinding.entregaProyectoFinalEditText.text.toString().toDouble()

                if (isValidGrade(labGrade) && isValidGrade(firstAdvanceGrade) && isValidGrade(secondAdvanceGrade) && isValidGrade(finalProjectGrade)) {
                    val finalGrade = calculateWeightedAverage(labGrade, firstAdvanceGrade, secondAdvanceGrade, finalProjectGrade)
                    mainBinding.noteFinalTextView.text = String.format("%.3f", finalGrade)
                } else {

                    Snackbar.make(mainBinding.linearLayout, "Tiene espacios sin llenar o los datos ingresados no son válidos. Por favor verifique", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Aceptar") {}
                        .show()
                         mainBinding.noteFinalTextView.text=" "
                }

            } catch (e: NumberFormatException) {
                Snackbar.make(mainBinding.linearLayout, "Tiene espacios sin llenar o los datos ingresados no son válidos. Por favor verifique", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Aceptar") {}
                    .show()
                     mainBinding.noteFinalTextView.text=" "
            }
        }
    }
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