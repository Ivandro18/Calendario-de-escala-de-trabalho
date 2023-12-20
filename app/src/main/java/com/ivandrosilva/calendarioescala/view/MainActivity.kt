package com.ivandrosilva.calendarioescala.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.adapters.MesAdapter
import com.ivandrosilva.calendarioescala.databinding.ActivityMainBinding
import com.ivandrosilva.calendarioescala.services.CalendarioService
import org.w3c.dom.Text
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    companion object{
        val calendarioService = CalendarioService(2023,2)// constroi as datas do calendario setando o ano de inicio e a quantidade de anos a ser controido
    }
    private val binding by lazy {    ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var mesAdapter: MesAdapter
    private var diaSelecionado = LocalDate.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listaMeses = calendarioService.getLista()

        mesAdapter = MesAdapter{ dia->
            diaSelecionado = dia.dataMapa
            diaSelecionado()
        }

        //mesAdapter = MesAdapter()

        mesAdapter.atualizarListaDados(listaMeses)  // atualizar a lista do recycler view
        binding.recyclerMes.adapter = mesAdapter
        binding.recyclerMes.scrollToPosition(calendarioService.getMesAtual())// vai para a pagina especifica
        diaSelecionado()

    }

    override fun onResume() {
        super.onResume()
        diaSelecionado = LocalDate.now()
    }

    fun diaSelecionado() {
        binding.txtDiaEvento.text = calendarioService.getDataFormatada(diaSelecionado)
    }
}