package com.stivenvelasquez.notafinaldispositivosmoviles.ui.main


import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.stivenvelasquez.notafinaldispositivosmoviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel:MainViewModel

    @SuppressLint("StringFormatInvalid")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout y obtener la instancia del binding
        mainBinding =ActivityMainBinding.inflate(layoutInflater)
        val view =mainBinding.root
        setContentView(view)

        // Inicializar el ViewModel
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //Botón de calcular la nota
        mainBinding.calculateNoteButton.setOnClickListener {
            try {

                // Informar al ViewModel de los cambios en los datos
                mainViewModel.notaLab(mainBinding.notaLabEditText.text.toString().toDouble())
                mainViewModel.notaPrimerAvance(mainBinding.notaPrimerAvanceEditText.text.toString().toDouble())
                mainViewModel.notaSegundoAvance(mainBinding.notaSegundoAvanceEditText.text.toString().toDouble())
                mainViewModel.notaProyectoFinal(mainBinding.entregaProyectoFinalEditText.text.toString().toDouble())
                mainViewModel.notaCalculada(mainBinding.noteFinalTextView.toString())

                val  notaCalculadaObserver= Observer<String>{ nota ->
                    mainBinding.noteFinalTextView.text=nota
                }
                mainViewModel.notaCalculada.observe(this, notaCalculadaObserver)


                if (mainViewModel.isValidGrade(mainBinding.notaLabEditText.text.toString().toDouble()) &&
                    mainViewModel.isValidGrade(mainBinding.notaPrimerAvanceEditText.text.toString().toDouble()) &&
                    mainViewModel.isValidGrade(mainBinding.notaSegundoAvanceEditText.text.toString().toDouble()) &&
                    mainViewModel.isValidGrade(mainBinding.entregaProyectoFinalEditText.text.toString().toDouble())) {

                    mainBinding.noteFinalTextView.text = String.format("%.3f", mainViewModel.calculateWeightedAverage(mainBinding.notaLabEditText.text.toString().toDouble(),
                        mainBinding.notaPrimerAvanceEditText.text.toString().toDouble(), mainBinding.notaSegundoAvanceEditText.text.toString().toDouble(),
                        mainBinding.entregaProyectoFinalEditText.text.toString().toDouble()))
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

//Termine el ejercicio