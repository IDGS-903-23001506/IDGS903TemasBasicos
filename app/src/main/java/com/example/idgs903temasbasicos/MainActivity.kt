package com.example.idgs903temasbasicos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.Practica1.Practica1Activity
import com.example.idgs903temasbasicos.Practica2.Practica2Activity
import com.example.idgs903temasbasicos.Practica3.Practica3Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnPractica1 = findViewById<Button>(R.id.btn1)
        val btnPractica2 = findViewById<Button>(R.id.btn2)
        val btnPractica3 = findViewById<Button>(R.id.btn3)

        btnPractica1.setOnClickListener { navigateToPractica1() }
        btnPractica2.setOnClickListener { navigateToPractica2() }
        btnPractica3.setOnClickListener { navigateToPractica3() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToPractica1() {
        startActivity(Intent(this, Practica1Activity::class.java))
    }

    private fun navigateToPractica2() {
        startActivity(Intent(this, Practica2Activity::class.java))
    }

    private fun navigateToPractica3() {
        startActivity(Intent(this, Practica3Activity::class.java))
    }
}
