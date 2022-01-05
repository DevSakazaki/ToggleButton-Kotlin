package com.example.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    lateinit var texto: TextView
    lateinit var interruptor: ToggleButton
    lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao = findViewById(R.id.button)
        texto = findViewById(R.id.textView)
        interruptor = findViewById(R.id.toggleButton)

        interruptor.setOnCheckedChangeListener{buttonView, isChecked -> isChecked
            texto.text = verificaInterruptor(isChecked)
        }

        botao.setOnClickListener{
            Toast.makeText(applicationContext, "Situação: " + verificaInterruptor(interruptor.isChecked), Toast.LENGTH_LONG).show()
        }
    }

    private fun verificaInterruptor(isChecked: Boolean): String {
        var textoExibir = ""
        if (isChecked) {
            textoExibir = "ligado"
        } else {
            textoExibir = "desligado"
        }
        return textoExibir
    }
}