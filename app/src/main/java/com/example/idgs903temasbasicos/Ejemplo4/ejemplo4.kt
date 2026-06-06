package com.example.idgs903temasbasicos.Ejemplo4

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ejemplo4 : AppCompatActivity() {
    lateinit var et1 : EditText
    lateinit var datos : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_ejemplo4)
        val btnOperasBas = findViewById<Button>(R.id.button2)
        et1 = findViewById<EditText>(R.id.et1)
        btnOperasBas.setOnClickListener { ActGuardar(this) }

        setContentView(R.layout.activity_ejemplo4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun ActGuardar(context: Context){
        try{
            println("hola")
            val file = File(context.filesDir, "notas.txt")
            val fos = FileOutputStream(file)
            val texto = this.et1.text.toString()
            fos.write(texto.toByteArray())
            fos.close()
        }catch(e: IOException){
            e.printStackTrace()
        }
        val t = Toast.makeText(this, "Los datos fueron guardados", Toast.LENGTH_LONG)
        t.show()
        finish()
    }
}