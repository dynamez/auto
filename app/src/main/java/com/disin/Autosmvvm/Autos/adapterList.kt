package com.disin.Autosmvvm.Autos

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.disin.examplemvvm.R
import com.disin.Autosmvvm.model.Auto

class adapterList(var contexto:Context, var listAutos:ArrayList<Auto>, var listener: onclickDelete):RecyclerView.Adapter<adapterList.viewholder>(){






    class viewholder(vista:View):RecyclerView.ViewHolder(vista){
        var card:CardView = vista.findViewById(R.id.card)
        var id:TextView = vista.findViewById(R.id.id)
        var color:TextView = vista.findViewById(R.id.color)
        var marca:TextView = vista.findViewById(R.id.marca)
        var anio:TextView = vista.findViewById(R.id.anio)
        var tipo:TextView = vista.findViewById(R.id.tipo)
        var imagendelete:ImageView = vista.findViewById(R.id.delete)

        init{

        }


    }








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        return viewholder(LayoutInflater.from(contexto).inflate(R.layout.itemslist,parent,false))

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.id.text=listAutos.get(position).id.toString()
        holder.color.text=listAutos.get(position).color
        holder.marca.text=listAutos.get(position).marca
        holder.anio.text=listAutos.get(position).anio.toString()
        holder.tipo.text=listAutos.get(position).tipo.toString()

        when (listAutos.get(position).color){
            "red"->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                holder.card.setCardBackgroundColor(contexto.getColor(R.color.red))
            }

            "blue"->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    holder.card.setCardBackgroundColor(contexto.getColor(R.color.blue))
                }

            "green"->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    holder.card.setCardBackgroundColor(contexto.getColor(R.color.green))
                }

            "yellow"->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    holder.card.setCardBackgroundColor(contexto.getColor(R.color.yellow))
                }
        }


    holder.imagendelete.setOnClickListener {

        listener.click(listAutos.get(position))
    }



    }



    override fun getItemCount(): Int {
      return listAutos.size
    }

}