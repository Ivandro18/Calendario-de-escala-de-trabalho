package com.ivandrosilva.calendarioescala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.dataclass.Dia

class EventoAbaixoAdapter : RecyclerView.Adapter<EventoAbaixoAdapter.EventoAbaixoViewHolder>() {

    private var eventos = mutableListOf<Dia>()

    inner class EventoAbaixoViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder( itemView )  {

        fun bind(dia: Dia) { // conecta com a interface


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoAbaixoViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.recycle_mes_view_item, parent, false
        )

        return EventoAbaixoViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: EventoAbaixoViewHolder, position: Int) {
        val mes = eventos[position]
        holder.bind(mes)
    }

    override fun getItemCount(): Int {
        return eventos.size
    }

    fun atualizarListaDados(novaLista: MutableList<Dia>) {
        eventos = novaLista //atualiza a lista
        notifyDataSetChanged() // notifica o recycler
    }
}