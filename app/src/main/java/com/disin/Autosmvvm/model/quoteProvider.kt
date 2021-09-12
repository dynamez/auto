package com.disin.Autosmvvm.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class quoteProvider {


//this class provider a data

    companion object {

        fun rellenaarlist(quantity: Int): QuoteModel {

            var listquote: ArrayList<QuoteModel> = ArrayList()

            for (b in 0..quantity) {
                listquote.add(QuoteModel("Esta es la cita numero $b", "Autor numero: $b"))
            }

            return listquote.random()
        }



        fun returnRetrofit(baseurl:String):Retrofit{

            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseurl).build()
        }



        fun getRequest(){

            GlobalScope.launch(Dispatchers.Main) {


              var result=  withContext(Dispatchers.IO){
                    returnRetrofit("url").create(request::class.java).getModel("url2")
                }

                if (result.isSuccessful){
                    var body= result.body()
                }
            }

        }




        fun retornarlist(quantity: Int): ArrayList<QuoteModel> {

            var listquote: ArrayList<QuoteModel> = ArrayList()

            for (b in 0..quantity) {
                listquote.add(QuoteModel("Esta es la cita numero $b", "Autor numero: $b"))
            }

            return listquote
        }
    }



}
