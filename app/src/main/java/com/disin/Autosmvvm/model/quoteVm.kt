package com.disin.Autosmvvm.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class quoteVm:ViewModel() {

val quoteModel = MutableLiveData<QuoteModel>()



    fun randomModel(){
        quoteModel.postValue(quoteProvider.rellenaarlist(10))
    }



}