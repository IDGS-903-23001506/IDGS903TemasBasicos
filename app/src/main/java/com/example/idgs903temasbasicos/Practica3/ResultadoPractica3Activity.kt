package com.example.idgs903temasbasicos.Practica3

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import java.util.Calendar

class ResultadoPractica3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_practica3)

        val txtNombreCompleto = findViewById<TextView>(R.id.txtNombreCompleto)
        val txtGenero = findViewById<TextView>(R.id.txtGenero)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)
        val txtSigno = findViewById<TextView>(R.id.txtSigno)
        val imgSigno = findViewById<ImageView>(R.id.imgSigno)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE").orEmpty()
        val apellidoPaterno = intent.getStringExtra("EXTRA_APELLIDO_PATERNO").orEmpty()
        val apellidoMaterno = intent.getStringExtra("EXTRA_APELLIDO_MATERNO").orEmpty()
        val genero = intent.getStringExtra("EXTRA_GENERO").orEmpty()
        val dia = intent.getIntExtra("EXTRA_DIA", 0)
        val mes = intent.getIntExtra("EXTRA_MES", 0)
        val anio = intent.getIntExtra("EXTRA_ANIO", 0)

        val signo = obtenerSignoChino(anio)

        txtNombreCompleto.text = "$nombre $apellidoPaterno $apellidoMaterno"
        txtGenero.text = "Genero: $genero"
        txtEdad.text = "Edad: ${calcularEdad(dia, mes, anio)} anios"
        txtSigno.text = "Signo chino: ${signo.nombre}"
        imgSigno.setImageBitmap(crearImagenSigno(signo.emoji))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcularEdad(dia: Int, mes: Int, anio: Int): Int {
        val hoy = Calendar.getInstance()
        var edad = hoy.get(Calendar.YEAR) - anio
        val aunNoCumpleAnios =
            hoy.get(Calendar.MONTH) + 1 < mes ||
                (hoy.get(Calendar.MONTH) + 1 == mes && hoy.get(Calendar.DAY_OF_MONTH) < dia)

        if (aunNoCumpleAnios) {
            edad--
        }

        return edad
    }

    private fun obtenerSignoChino(anio: Int): SignoChino {
        val signos = listOf(
            SignoChino("Rata", "\uD83D\uDC00"),
            SignoChino("Buey", "\uD83D\uDC02"),
            SignoChino("Tigre", "\uD83D\uDC05"),
            SignoChino("Conejo", "\uD83D\uDC07"),
            SignoChino("Dragon", "\uD83D\uDC09"),
            SignoChino("Serpiente", "\uD83D\uDC0D"),
            SignoChino("Caballo", "\uD83D\uDC0E"),
            SignoChino("Cabra", "\uD83D\uDC10"),
            SignoChino("Mono", "\uD83D\uDC12"),
            SignoChino("Gallo", "\uD83D\uDC13"),
            SignoChino("Perro", "\uD83D\uDC15"),
            SignoChino("Cerdo", "\uD83D\uDC16")
        )

        return signos[Math.floorMod(anio - 1900, signos.size)]
    }

    private fun crearImagenSigno(emoji: String): Bitmap {
        val size = 300
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val fondo = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#E4ECF7")
        }
        canvas.drawCircle(size / 2f, size / 2f, size / 2.2f, fondo)

        val paintEmoji = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = 160f
            typeface = Typeface.DEFAULT_BOLD
        }

        val y = size / 2f - (paintEmoji.descent() + paintEmoji.ascent()) / 2
        canvas.drawText(emoji, size / 2f, y, paintEmoji)
        return bitmap
    }
}

data class SignoChino(val nombre: String, val emoji: String)
