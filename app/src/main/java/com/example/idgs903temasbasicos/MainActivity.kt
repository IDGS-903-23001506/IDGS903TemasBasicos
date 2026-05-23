package com.example.idgs903temasbasicos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.Ejemplo1.OperasBasActivity
import com.example.idgs903temasbasicos.Ejemplo2.SaludoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOperasBas=findViewById<Button>(R.id.btn1)
        val btnSaludo = findViewById<Button>(R.id.btn2)

        btnOperasBas.setOnClickListener { navigateToOperasBas() }
        btnSaludo.setOnClickListener { navigateToSaludo() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun navigateToOperasBas(){
        val intent = Intent(this, OperasBasActivity::class.java)
        startActivity(
            intent
        )
    }
    fun navigateToSaludo(){
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(
            intent
        )
    }
}