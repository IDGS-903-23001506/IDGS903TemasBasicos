package com.example.idgs903temasbasicos.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs903temasbasicos.R
import android.widget.RadioButton

class OperasBasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var edtNumero1: EditText
        lateinit var edtNumero2: EditText
        lateinit var txtResultado : TextView
        lateinit var rbSumar: RadioButton
        lateinit var rbRestar: RadioButton
        lateinit var rbMultiplicar: RadioButton
        lateinit var rbDividir: RadioButton
        lateinit var btnCalcular: Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas_bas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtNumero1 = findViewById(R.id.edt1)
        edtNumero2 = findViewById(R.id.edt2)
        txtResultado = findViewById(R.id.txtResultado)
        rbSumar = findViewById(R.id.rbSumar)
        rbRestar = findViewById(R.id.rbRestar)
        rbMultiplicar = findViewById(R.id.rbMultiplicar)
        rbDividir = findViewById(R.id.rbDividir)

        btnCalcular = findViewById(R.id.btnCalcular)


        btnCalcular.setOnClickListener {

            val num1 = Integer.parseInt(edtNumero1.text.toString())
            val num2 = Integer.parseInt(edtNumero2.text.toString())

            if(rbSumar.isChecked){
                txtResultado.setText("Resultado: " +sumar(numero1 = num1, numero2 = num2))
            }
            if(rbRestar.isChecked){
                txtResultado.setText("Resultado: " +restar(numero1 = num1, numero2 = num2))
            }
            if(rbMultiplicar.isChecked){
                txtResultado.setText("Resultado: " +multiplicar(numero1 = num1, numero2 = num2))
            }
            if(rbDividir.isChecked){
                txtResultado.setText("Resultado: " +dividir(numero1 = num1, numero2 = num2))
            }
        }

    }

    fun sumar(numero1:Int, numero2:Int):Int{
        return numero1+numero2
    }
    fun restar(numero1:Int, numero2:Int):Int{
        return numero1-numero2
    }
    fun multiplicar(numero1:Int, numero2:Int):Int{
        return numero1*numero2
    }
    fun dividir(numero1:Int, numero2:Int): Float{
        return numero1.toFloat()/numero2.toFloat()
    }
}