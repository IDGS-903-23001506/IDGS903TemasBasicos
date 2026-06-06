package com.example.idgs903temasbasicos.Practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import kotlin.math.pow
import kotlin.math.sqrt

class Practica1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica1)

        val edtX1 = findViewById<EditText>(R.id.edtX1)
        val edtY1 = findViewById<EditText>(R.id.edtY1)
        val edtX2 = findViewById<EditText>(R.id.edtX2)
        val edtY2 = findViewById<EditText>(R.id.edtY2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularDistancia)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoDistancia)

        btnCalcular.setOnClickListener {
            val x1 = edtX1.text.toString().toDoubleOrNull()
            val y1 = edtY1.text.toString().toDoubleOrNull()
            val x2 = edtX2.text.toString().toDoubleOrNull()
            val y2 = edtY2.text.toString().toDoubleOrNull()

            if (x1 == null || y1 == null || x2 == null || y2 == null) {
                Toast.makeText(this, "Captura los cuatro valores", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val distancia = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
            txtResultado.text = "Distancia: %.2f".format(distancia)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
