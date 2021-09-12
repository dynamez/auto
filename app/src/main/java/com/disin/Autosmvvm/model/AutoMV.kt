package com.disin.Autosmvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AutoMV(): ViewModel() {

    var livedata= MutableLiveData<ArrayList<Auto>>()
    var listmodificada = ArrayList<Auto>()







    fun adddata(auto:Auto){

        listmodificada=livedata.value!!
        listmodificada.add(auto)
        livedata.value=listmodificada



    }

    fun deletedata(auto: Auto){
        listmodificada=livedata.value!!
        listmodificada.remove(auto)
        livedata.value=listmodificada

    }




    fun setlist(){
        livedata.value= providerCar.providerListCar()
    }




}