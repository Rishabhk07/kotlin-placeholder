package com.codingblocks.kotlinplaceholder.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.kotlinplaceholder.R
import com.codingblocks.kotlinplaceholder.model.Post
import retrofit2.http.POST
import java.sql.Array
import kotlinx.android.synthetic.main.posts_layout.view.*
/**
 * Created by rishabhkhanna on 12/07/17.
 */

class PostAdapter(val context: Context, val posts: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.posts_layout,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindPost(posts[position])
    }

    inner class PostViewHolder (val thisView: View): RecyclerView.ViewHolder(thisView){
        fun bindPost(posts: Post){
            thisView.tvTitle.text = posts.title
            thisView.tvBody.text = posts.body
        }
    }
}
