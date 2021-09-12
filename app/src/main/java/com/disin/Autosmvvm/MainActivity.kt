package com.disin.Autosmvvm

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.disin.examplemvvm.databinding.ActivityMainBinding
import com.disin.Autosmvvm.model.quoteProvider
import com.disin.Autosmvvm.model.quoteVm
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

   lateinit var binding:ActivityMainBinding
    val viewmodel: quoteVm = quoteVm()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewmodel.quoteModel.observe(this, Observer {
            binding.titleautor.text=it.autor
            binding.titlequote.text=it.quote

        })


          binding.container.setOnClickListener {
              viewmodel.randomModel()

          }


    }



}