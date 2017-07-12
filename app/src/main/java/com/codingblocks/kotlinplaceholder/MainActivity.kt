package com.codingblocks.kotlinplaceholder

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.codingblocks.kotlinplaceholder.API.API
import com.codingblocks.kotlinplaceholder.API.jsonApi
import com.codingblocks.kotlinplaceholder.adapter.UserAdapter
import com.codingblocks.kotlinplaceholder.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userAdapter = UserAdapter(this, ArrayList<User>())
        rvUser.layoutManager = LinearLayoutManager(this)
        rvUser.adapter = userAdapter
        rvUser.setOnClickListener {
            Log.d("TAG", "getInstance: ")
        }
        API.getIn()
                .retrofit
                .create(jsonApi::class.java)
                .getUsers().enqueue(object: Callback<ArrayList<User>>{
            override fun onResponse(call: Call<ArrayList<User>>?, response: Response<ArrayList<User>>?) {
                userAdapter.updateUser(response!!.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<User>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

//        .class in kotlin is ::class.java

    }
}
