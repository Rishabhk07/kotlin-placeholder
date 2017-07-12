package com.codingblocks.kotlinplaceholder.API;

import android.util.Log;

import retrofit2.Retrofit;

/**
 * Created by rishabhkhanna on 12/07/17.
 */

public class APIJ {
    Retrofit retrofit;
    static APIJ apij;

    public APIJ() {
        this.retrofit = new Retrofit.Builder().baseUrl("http://google.com").build();
    }

    public static APIJ getInstance(){
        if (apij == null){
            apij = new APIJ();
            Log.d("TAG", "getInstance: ");
        }
        return apij;
    }
}
