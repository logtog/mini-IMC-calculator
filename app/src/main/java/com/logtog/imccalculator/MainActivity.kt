package com.logtog.imccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        editTextPeso?.doOnTextChanged {text, _,_,_ ->
            textIMC?.text = text
        }
        editTextPeso?.doAfterTextChanged {
            calcularIMC(editTextPeso.text.toString(), editTextAltura.text.toString())
        }
        editTextAltura?.doOnTextChanged {text,_,_,_ ->
            textIMC?.text = text
        }
        editTextAltura?.doAfterTextChanged {
            calcularIMC(editTextPeso.text.toString(), editTextAltura.text.toString())
        }
        btnCalcular?.setOnClickListener {
            calcularIMC(editTextPeso.text.toString(), editTextAltura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            textIMC.text = "Seu IMC é: %.2f".format(imc)
        }
    }
}