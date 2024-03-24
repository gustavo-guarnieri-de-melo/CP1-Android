package com.fiap.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.fiap.calculadora.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.botaoLimpar.setOnClickListener {
            binding.entrada.text = ""
            binding.resultado.text = ""
        }

        binding.botaoParentesesAbrir.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("(")
        }
        binding.botaoParentesesFechar.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada(")")
        }

        binding.botaoCroxx.setOnClickListener {
            val removidoUltimo = entrada.text.toString().dropLast(1)
            entrada.text = removidoUltimo
        }

        binding.botao0.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("0")
        }
        binding.botao1.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("1")
        }
        binding.botao2.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("2")
        }
        binding.botao3.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("3")
        }
        binding.botao4.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("4")
        }
        binding.botao5.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("5")
        }
        binding.botao6.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("6")
        }
        binding.botao7.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("7")
        }
        binding.botao8.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("8")
        }
        binding.botao9.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("9")
        }
        binding.botaoPonto.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada(".")
        }
        binding.botaoDivisao.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("÷")
        }
        binding.botaoMultiplicacao.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("×")
        }

        binding.botaoSubtracao.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("-")
        }
        binding.botaoAdicao.setOnClickListener {
            entrada.text = adicionarAoTextoDeEntrada("+")
        }

        binding.botaoIgual.setOnClickListener {
            mostrarResultado()
        }
    }

    private fun adicionarAoTextoDeEntrada(valorBotao: String): String {
        return entrada.text.toString() + "" + valorBotao
    }

    private fun obterExpressaoDeEntrada(): String {
        var expressao = entrada.text.replace(Regex("÷"), "/")
        expressao = expressao.replace(Regex("×"), "*")
        return expressao
    }

    private fun mostrarResultado() {
        try {
            val expressao = obterExpressaoDeEntrada()
            val resultadoCalculado = Expression(expressao).calculate()
            if (resultadoCalculado.isNaN()) {
                resultado.text = ""
                resultado.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                resultado.text = DecimalFormat("0.######").format(resultadoCalculado).toString()
                resultado.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            resultado.text = ""
            resultado.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}
