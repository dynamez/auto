package com.disin.Autosmvvm.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("cuoteName") var quote:String,@SerializedName("autorName") var autor:String) {
}