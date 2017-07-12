package com.codingblocks.kotlinplaceholder.API

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rishabhkhanna on 12/07/17.
 */

class API {
   var retrofit: Retrofit

//    internal var is private for java
    init {
        this.retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .build()
    }
    companion object{
        var instance: API? = null
        fun getIn():API{
            if (instance == null){
                instance = API()
            }
            return instance!!
        }
        val getInstance: API
        get() {
            if (instance == null) {
                instance = API()
            }
            return instance!!
        }
    }

//    difference between object and companion object
}