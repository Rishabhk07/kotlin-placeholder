package com.codingblocks.kotlinplaceholder.API

import retrofit2.Retrofit

/**
 * Created by rishabhkhanna on 12/07/17.
 */

class APIJAVA {
    var retrofit: Retrofit

    init {
        this.retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
    }

    companion object {
        var apijava: APIJAVA? = null
        val instance: APIJAVA
            get() {

                if (apijava == null) {
                    APIJAVA()
                }
                return apijava!!
            }
    }
}
