package com.example.ejemplospinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinner = findViewById<Spinner>(R.id.estados_civiles)
        val estadosCiviles = resources.getStringArray(R.array.estados_civiles)

     //   val estadosCiviles = arrayOf("Soltero/a", "Casado/a", "Unión libre o unión de hecho","Separado/a", "Divorciado/a", "Viudo/a")

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, estadosCiviles
            )
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Maneja la selección del usuario
                val selectedState = estadosCiviles[position]
                Toast.makeText(this@MainActivity, "Estado civil seleccionado: $selectedState", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Método requerido, pero no necesitamos hacer nada aquí
            }
        }


        val  button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            val selectedState = spinner.selectedItem as String
            Toast.makeText(this@MainActivity, "Estado civil seleccionado: $selectedState", Toast.LENGTH_SHORT).show()
        }
    }
}