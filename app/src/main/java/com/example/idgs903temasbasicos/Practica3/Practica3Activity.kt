package com.example.idgs903temasbasicos.Practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import java.util.Calendar
import java.util.GregorianCalendar

class Practica3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practica3)

        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtApellidoPaterno = findViewById<EditText>(R.id.edtApellidoPaterno)
        val edtApellidoMaterno = findViewById<EditText>(R.id.edtApellidoMaterno)
        val edtDia = findViewById<EditText>(R.id.edtDia)
        val edtMes = findViewById<EditText>(R.id.edtMes)
        val edtAnio = findViewById<EditText>(R.id.edtAnio)
        val cbFemenino = findViewById<CheckBox>(R.id.cbFemenino)
        val btnMostrar = findViewById<Button>(R.id.btnMostrarResultado)

        btnMostrar.setOnClickListener {
            val nombre = edtNombre.text.toString().trim()
            val apellidoPaterno = edtApellidoPaterno.text.toString().trim()
            val apellidoMaterno = edtApellidoMaterno.text.toString().trim()
            val dia = edtDia.text.toString().toIntOrNull()
            val mes = edtMes.text.toString().toIntOrNull()
            val anio = edtAnio.text.toString().toIntOrNull()

            if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty()) {
                Toast.makeText(this, "Captura el nombre completo", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (dia == null || mes == null || anio == null || !esFechaValida(dia, mes, anio)) {
                Toast.makeText(this, "La fecha de nacimiento no es valida", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultadoPractica3Activity::class.java)
            intent.putExtra("EXTRA_NOMBRE", nombre)
            intent.putExtra("EXTRA_APELLIDO_PATERNO", apellidoPaterno)
            intent.putExtra("EXTRA_APELLIDO_MATERNO", apellidoMaterno)
            intent.putExtra("EXTRA_DIA", dia)
            intent.putExtra("EXTRA_MES", mes)
            intent.putExtra("EXTRA_ANIO", anio)
            intent.putExtra("EXTRA_GENERO", if (cbFemenino.isChecked) "Femenino" else "Masculino")
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun esFechaValida(dia: Int, mes: Int, anio: Int): Boolean {
        if (anio < 1900) {
            return false
        }

        return try {
            val fechaNacimiento = GregorianCalendar(anio, mes - 1, dia).apply {
                isLenient = false
                time
            }
            !fechaNacimiento.after(Calendar.getInstance())
        } catch (_: IllegalArgumentException) {
            false
        }
    }
}
