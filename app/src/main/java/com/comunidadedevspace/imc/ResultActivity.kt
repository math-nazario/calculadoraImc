package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultado = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvClassificacao = findViewById<TextView>(R.id.tvClassificacao)
        tvResultado.text = resultado.toString()

        val classificacao: String = if (resultado <= 18.5f) {
            "MAGREZA"
        } else if (resultado > 18.5f && resultado <= 24.9f) {
            "NORMAL"
        } else if (resultado > 25f && resultado <= 39.9f) {
            "SOBREPESO"
        } else {
            "OBSIDADE GRAVE"
        }
        tvClassificacao.text = classificacao
    }
}