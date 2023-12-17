package com.ivandrosilva.calendarioescala.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.adapters.MesAdapter
import com.ivandrosilva.calendarioescala.services.CalendarioService

class MainActivity : AppCompatActivity() {



    private lateinit var mesAdapter: MesAdapter
    private lateinit var rvListaMes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarioService = CalendarioService(2022,5)
        val listaMeses = calendarioService.getLista()

        rvListaMes = findViewById(R.id.recyclerMes) // instancia o recycler view

        mesAdapter = MesAdapter{ nome ->
            Toast.makeText(this, "Mes de  $nome", Toast.LENGTH_SHORT).show()// popup na tela
        }

        //mesAdapter = MesAdapter()

        mesAdapter.atualizarListaDados(listaMeses)  // atualizar a lista do recycler view

        rvListaMes.adapter = mesAdapter

        rvListaMes.layoutManager = LinearLayoutManager( this)// cria o layout do recyclerView
        rvListaMes.scrollToPosition(calendarioService.getMesAtual())// vai para a pagina especifica
    }
}