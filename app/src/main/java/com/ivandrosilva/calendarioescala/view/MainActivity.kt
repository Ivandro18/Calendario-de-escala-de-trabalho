package com.ivandrosilva.calendarioescala.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.adapters.EventoAbaixoAdapter
import com.ivandrosilva.calendarioescala.databinding.ActivityMainBinding
import com.ivandrosilva.calendarioescala.services.CalendarioService
import org.w3c.dom.Text
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val binding by lazy {    ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var mesAdapter: EventoAbaixoAdapter
    private var diaSelecionado = LocalDate.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val calendarioService = CalendarioService(2023,2)// constroi as datas do calendario setando o ano de inicio e a quantidade de anos a ser controido
        val listaMeses = calendarioService.getLista()
        var diaSelecionadoView: CardView? = null

        mesAdapter = EventoAbaixoAdapter{ dia, card->
            Toast.makeText(this, "Mes de  $dia", Toast.LENGTH_SHORT).show()// popup na tela
            if (diaSelecionadoView != card){ // faz auternar o dia do mes que foi selecionado
                diaSelecionadoView?.setBackgroundResource(R.color.white)
                diaSelecionadoView = card
            }
            diaSelecionado = dia.dataMapa
            diaSelecionado()
        }

        //mesAdapter = MesAdapter()

        mesAdapter.atualizarListaDados(listaMeses)  // atualizar a lista do recycler view
        binding.recyclerMes.adapter = mesAdapter
        binding.recyclerMes.scrollToPosition(calendarioService.getMesAtual())// vai para a pagina especifica
        diaSelecionado()

    }

    fun diaSelecionado(){
        binding.txtDiaEvento.text = CalendarioService.getDataFormatada(diaSelecionado)
    }
}