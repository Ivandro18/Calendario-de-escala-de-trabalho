package com.ivandrosilva.calendarioescala.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.adapters.MesAdapter
import com.ivandrosilva.calendarioescala.services.CalendarioService

class MainActivity : AppCompatActivity() {



    private lateinit var mesAdapter: MesAdapter
    private lateinit var rvListaMes: RecyclerView
    private lateinit var botao: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarioService = CalendarioService(2023,2)
        val listaMeses = calendarioService.getLista()
        var diaSelecionado: CardView? = null
        rvListaMes = findViewById(R.id.recyclerMes) // instancia o recycler view

        mesAdapter = MesAdapter{ dia , card->
            Toast.makeText(this, "Mes de  $dia", Toast.LENGTH_SHORT).show()// popup na tela
            if (diaSelecionado != card){ // faz auternar o dia do mes que foi selecionado
                diaSelecionado?.setBackgroundResource(R.color.white)
                diaSelecionado = card
            }
        }

        //mesAdapter = MesAdapter()

        mesAdapter.atualizarListaDados(listaMeses)  // atualizar a lista do recycler view

        rvListaMes.adapter = mesAdapter

        rvListaMes.layoutManager = LinearLayoutManager( this)// cria o layout do recyclerView
        rvListaMes.scrollToPosition(calendarioService.getMesAtual())// vai para a pagina especifica

        botao = findViewById(R.id.button)
        botao.setOnClickListener{
            mesAdapter.atualizarListaDados(listaMeses)
        }
    }
}