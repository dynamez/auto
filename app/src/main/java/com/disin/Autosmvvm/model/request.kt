package com.disin.Autosmvvm.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface request {


    @GET
    fun getModel(@Url url:String):Response<QuoteModel>
}