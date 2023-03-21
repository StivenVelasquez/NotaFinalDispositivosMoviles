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

            mainViewModel.calculateWeightedAverage(mainBinding.notaLabEditText.text.toString().toDouble(),
              mainBinding.notaPrimerAvanceEditText.text.toString().toDouble(), mainBinding.notaSegundoAvanceEditText.text.toString().toDouble(),
                 mainBinding.entregaProyectoFinalEditText.text.toString().toDouble(), mainBinding.linearLayout)

        val  notaCalculadaObserver= Observer<String>{ nota ->
            mainBinding.noteFinalTextView.text= nota
        }
        mainViewModel.weightedAverage.observe(this, notaCalculadaObserver)
        }
    }
}

//  Checkeo del ejercicio