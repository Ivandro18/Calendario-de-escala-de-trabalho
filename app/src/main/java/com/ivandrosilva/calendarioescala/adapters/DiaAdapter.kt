package com.ivandrosilva.calendarioescala.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.ivandrosilva.calendarioescala.R
import com.ivandrosilva.calendarioescala.dataclass.Dia
import java.time.LocalDate

class DiaAdapter(
private val clique: (String,CardView) -> Unit // evento de clique do item do recycle
)
 : RecyclerView.Adapter<DiaAdapter.DiaViewHolder>() {
    private var dias = mutableListOf<Dia>()
    inner class DiaViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder( itemView )  {
        val cdDia: CardView = itemView.findViewById(R.id.cdDia)
        val txtDia: TextView = itemView.findViewById(R.id.textDia)
        val heHoje: ImageView = itemView.findViewById(R.id.marcaDiaAtual)

        fun bind(dia: Dia) {
            if (dia.dia == ""){ // deixa invisivel os primeiros dias do mes antes do inicio
                cdDia.isInvisible = true
            }else {
                txtDia.text = dia.dia
                if (LocalDate.now() == dia.dataMapa){
                    txtDia.setTextColor(Color.WHITE)
                    heHoje.isInvisible = false
                }
            }
            cdDia.setOnClickListener {
                clique(dia.dia,cdDia)
                cdDia.setBackgroundResource(R.color.verde)
            }
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