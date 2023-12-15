package com.ivandrosilva.calendarioescala.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R

class DiaAdapter
//private val clique: (String) -> Unit // evento de clique do item do recycle
 : RecyclerView.Adapter<DiaAdapter.DiaViewHolder>() {
    private var listadias = mutableListOf<Int>()

    init {
        for (i in 1..42){ // simular os dias do mes
            listadias.add(i)
        }
    }

    inner class DiaViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder( itemView )  {
        val txtDia: TextView = itemView.findViewById(R.id.textDia)
        fun bind(dia: Int) {
            txtDia.text = dia.toString()

//            txtMes.setOnClickListener{
//                clique(mes.mes)
//            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaAdapter.DiaViewHolder {



        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.dias_view_item, parent, false
        )

        return DiaViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: DiaViewHolder, position: Int) {
        val dia = listadias[position]
        holder.bind(dia)
    }

    override fun getItemCount(): Int {
        return listadias.size
    }


}