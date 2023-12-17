package com.ivandrosilva.calendarioescala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.dataclass.Dia

class DiaAdapter
//private val clique: (String) -> Unit // evento de clique do item do recycle
 : RecyclerView.Adapter<DiaAdapter.DiaViewHolder>() {
    private var dias = mutableListOf<Dia>()

    inner class DiaViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder( itemView )  {
        val txtDia: TextView = itemView.findViewById(R.id.textDia)
        fun bind(dia: Dia) {
            txtDia.text = dia.dia

//            txtMes.setOnClickListener{
//                clique(mes.mes)
//            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaViewHolder {



        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.dias_view_item, parent, false
        )

        return DiaViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: DiaViewHolder, position: Int) {
        val dia = dias[position]
        holder.bind(dia)
    }

    override fun getItemCount(): Int {
        return dias.size
    }

    fun atualizarListaDados(novaLista: MutableList<Dia>) {
        dias = novaLista //atualiza a lista
        notifyDataSetChanged() // notifica o recycler
    }


}