package com.disin.Autosmvvm.Autos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.disin.Autosmvvm.model.Auto
import com.disin.Autosmvvm.model.providerCar
import com.disin.examplemvvm.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 * Use the [CreateCarFr.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateCarFr(var contexto:Context,var listener:onclickAdd) : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_create_car, container, false)


        var adapter = ArrayAdapter<String>(contexto,R.layout.support_simple_spinner_dropdown_item,providerCar.providerlistTypeCar())
        var adaptercolors = ArrayAdapter<String>(contexto,R.layout.support_simple_spinner_dropdown_item,providerCar.providerlistColorcar())

        view.findViewById<Spinner>(R.id.sptipo).adapter=adapter
        view.findViewById<Spinner>(R.id.color).adapter=adaptercolors


        view.findViewById<Button>(R.id.btn).setOnClickListener {

            if (validar(view)){
                listener.onclick(Auto(0,view.findViewById<Spinner>(R.id.color).selectedItem.toString(),view.findViewById<TextInputEditText>(R.id.etmarca).text.toString(),view.findViewById<TextInputEditText>(R.id.etanio).text.toString().toInt(),view.findViewById<Spinner>(R.id.sptipo).selectedItem.toString()))

            }else{
                Toast.makeText(contexto,"Ingrese todas las opciones primero",Toast.LENGTH_SHORT).show()
            }


        }

        return view



    }


    fun validar(vista:View):Boolean{
        var flag= true

        if (vista.findViewById<TextInputEditText>(R.id.etanio).text.toString().isNullOrEmpty() ||
            vista.findViewById<TextInputEditText>(R.id.etmarca).text.toString().isNullOrEmpty() ||
            vista.findViewById<Spinner>(R.id.sptipo).selectedItem.toString().equals("Seleccione una opcion") ||
            vista.findViewById<Spinner>(R.id.color).selectedItem.toString().equals("Seleccione una opcion")
        ){
        flag=false
        }
        return flag
    }

}