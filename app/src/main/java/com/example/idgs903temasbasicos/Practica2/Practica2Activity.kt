package com.example.idgs903temasbasicos.Practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R

class Practica2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica2)

        val edtLado1 = findViewById<EditText>(R.id.edtLado1)
        val edtLado2 = findViewById<EditText>(R.id.edtLado2)
        val edtLado3 = findViewById<EditText>(R.id.edtLado3)
        val btnMostrarResultado = findViewById<Button>(R.id.btnMostrarResultadoP2)

        btnMostrarResultado.setOnClickListener {
            val lado1 = edtLado1.text.toString().toDoubleOrNull()
            val lado2 = edtLado2.text.toString().toDoubleOrNull()
            val lado3 = edtLado3.text.toString().toDoubleOrNull()

            if (lado1 == null || lado2 == null || lado3 == null) {
                Toast.makeText(this, "Captura los tres lados", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultadoPractica2Activity::class.java)
            intent.putExtra("EXTRA_LADO_1", lado1)
            intent.putExtra("EXTRA_LADO_2", lado2)
            intent.putExtra("EXTRA_LADO_3", lado3)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
