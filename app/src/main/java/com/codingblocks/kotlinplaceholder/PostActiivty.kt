package com.codingblocks.kotlinplaceholder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.codingblocks.kotlinplaceholder.API.API
import com.codingblocks.kotlinplaceholder.API.jsonApi
import com.codingblocks.kotlinplaceholder.adapter.PostAdapter
import com.codingblocks.kotlinplaceholder.model.Post
import kotlinx.android.synthetic.main.activity_post_actiivty.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActiivty : AppCompatActivity() {
    val TAG = "PostsActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_actiivty)
        val id = intent.extras["id"]
        // difference between "as String" and toString()
        rvPosts.layoutManager = LinearLayoutManager(this)
        val postsArray = ArrayList<Post>()
        val postAdapter = PostAdapter(this,posts = postsArray)
        rvPosts.adapter = postAdapter
        API.getInstance
                .retrofit
                .create(jsonApi::class.java)
                .getUserPosts(id.toString())
                .enqueue(object: Callback<ArrayList<Post>> {
                    override fun onFailure(call: Call<ArrayList<Post>>?, t: Throwable?) {
                        Log.d(TAG,"Failed to Download ")
                        Toast.makeText(this@PostActiivty,"Failed to download",Toast.LENGTH_LONG).show()

                    }

                    override fun onResponse(call: Call<ArrayList<Post>>?, response: Response<ArrayList<Post>>?) {
                        postsArray.addAll(response!!.body()!!)
                        postAdapter.notifyDataSetChanged()
                    }

                })
    }
}
