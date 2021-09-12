package com.disin.Autosmvvm.Autos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.disin.examplemvvm.R
import com.disin.Autosmvvm.model.Auto
import com.disin.Autosmvvm.model.AutoMV
import com.google.android.material.snackbar.Snackbar

class ActiviyListAutos : AppCompatActivity(){

var contexto:Context = this

    var viewmodel= AutoMV()

        lateinit var lmanager:RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //agrego los autos
        viewmodel.setlist()

        var frcar = CreateCarFr(contexto,object:onclickAdd{
            override fun onclick(auto:Auto) {
                auto.id=retornarultimo()
                viewmodel.adddata(auto)
                Toast.makeText(contexto,"auto registrado correctamente",Toast.LENGTH_SHORT).show()
            }
        })

        setViewFr(frcar)

        var recycler :RecyclerView = findViewById(R.id.recycler)
        lmanager=LinearLayoutManager(this)







        viewmodel.livedata.observe(this, Observer {

            var adapter= adapterList(this,it,object : onclickDelete {
                override fun click(auto: Auto) {

                    Snackbar.make(findViewById(R.id.card),"eliminar auto que contiene id: "+auto.id,Snackbar.LENGTH_SHORT).setAction("Eliminar",View.OnClickListener {

                        viewmodel.deletedata(auto)

                    }).show()


                }
            })



               recycler.adapter=adapter
            recycler.layoutManager=lmanager
            adapter.notifyDataSetChanged()

        })


    }



    fun setViewFr(fr: CreateCarFr){
        supportFragmentManager.beginTransaction().replace(R.id.fr,fr,null).commit()
    }


    fun retornarultimo():Int{
        var number =0

        for (i in 0..viewmodel.livedata.value!!.size -1){

            if (viewmodel.livedata.value!!.get(i).id>number){
                number=viewmodel.livedata.value!!.get(i).id
            }

        }
        return number+1
    }


}