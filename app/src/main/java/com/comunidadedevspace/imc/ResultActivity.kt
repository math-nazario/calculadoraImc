package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        val classificacao: String = if (resultado < 18.5f) {
            "Abaixo do peso"
        } else if (resultado >= 18.5f && resultado <= 24.9f) {
            "Peso ideal"
        } else if (resultado >= 25f && resultado <= 29.9f) {
            "Sobrepeso"
        } else if (resultado >= 30f && resultado <= 34.9f) {
            "Obesidade grau 1"
        } else if (resultado >= 35f && resultado <= 39.9f) {
            "Obesidade grau 2 (Severa)"
        } else {
            "Obesidade grau 3 (Mórbida)"
        }
        tvClassificacao.text = classificacao

        val coresClassificacao: Int = when (classificacao) {
            "Abaixo do peso" -> android.graphics.Color.rgb(72, 61, 139)
            "Peso ideal" -> android.graphics.Color.rgb(0, 128, 0)
            "Sobrepeso" -> android.graphics.Color.rgb(255, 215, 0)
            "Obesidade grau 1" -> android.graphics.Color.rgb(255, 140, 0)
            "Obesidade grau 2 (Severa)" -> android.graphics.Color.rgb(255, 0, 0)
            "Obesidade grau 3 (Mórbida)" -> android.graphics.Color.rgb(128, 0, 128)
            else -> android.graphics.Color.BLACK
        }
        tvClassificacao.setTextColor(coresClassificacao)

        val btnTable = findViewById<Button>(R.id.btnTabela)
        btnTable.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            startActivity(intent)
        }
    }
}