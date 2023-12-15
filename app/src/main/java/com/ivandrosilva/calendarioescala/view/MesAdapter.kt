package com.ivandrosilva.calendarioescala.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.dataclass.Mes

class MesAdapter(
    private val clique: (String) -> Unit // evento de clique do item do recycle
) : RecyclerView.Adapter<MesAdapter.MesViewHolder>() {

    private var listaMeses = mutableListOf<Mes>()

    inner class MesViewHolder(
        itemView: View
    ) : ViewHolder( itemView )  {

        val txtMes: TextView = itemView.findViewById(R.id.txtMes)

        fun bind(mes: Mes) { // conecta com a interface
            txtMes.text = mes.mes

            txtMes.setOnClickListener{
                clique(mes.mes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MesViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.recycle_mes_view_item, parent, false
        )

        return MesViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: MesViewHolder, position: Int) {
        val mes = listaMeses[position]
        holder.bind(mes)
    }

    override fun getItemCount(): Int {
        return listaMeses.size
    }

    fun atualizarListaDados(novaLista: MutableList<Mes>) {
        listaMeses = novaLista //atualiza a lista
        notifyDataSetChanged() // notifica o recycler
    }
}