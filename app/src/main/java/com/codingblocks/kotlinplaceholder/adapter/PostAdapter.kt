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

/**
 * Created by rishabhkhanna on 12/07/17.
 */

class PostAdapter(context: Context, posts: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder (thisView: View): RecyclerView.ViewHolder(thisView){
        fun bind
    }
}
