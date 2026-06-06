package com.example.idgs903temasbasicos.Practica2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import kotlin.math.sqrt

class ResultadoPractica2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_practica2)

        val txtResultado = findViewById<TextView>(R.id.txtResultadoPractica2)

        val lado1 = intent.getDoubleExtra("EXTRA_LADO_1", 0.0)
        val lado2 = intent.getDoubleExtra("EXTRA_LADO_2", 0.0)
        val lado3 = intent.getDoubleExtra("EXTRA_LADO_3", 0.0)

        txtResultado.text = obtenerResultado(lado1, lado2, lado3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun obtenerResultado(lado1: Double, lado2: Double, lado3: Double): String {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            return "Los lados deben ser mayores a cero"
        }

        if (!esTriangulo(lado1, lado2, lado3)) {
            return "Los valores no forman un triangulo"
        }

        val semiperimetro = (lado1 + lado2 + lado3) / 2
        val area = sqrt(
            semiperimetro *
                (semiperimetro - lado1) *
                (semiperimetro - lado2) *
                (semiperimetro - lado3)
        )

        return "Si forman un triangulo\nArea: %.2f".format(area)
    }

    private fun esTriangulo(lado1: Double, lado2: Double, lado3: Double): Boolean {
        return lado1 + lado2 > lado3 &&
            lado1 + lado3 > lado2 &&
            lado2 + lado3 > lado1
    }
}
