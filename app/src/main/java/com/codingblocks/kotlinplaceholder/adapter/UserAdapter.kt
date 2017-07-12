package com.codingblocks.kotlinplaceholder.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.kotlinplaceholder.PostActiivty
import com.codingblocks.kotlinplaceholder.R
import com.codingblocks.kotlinplaceholder.model.User

import kotlinx.android.synthetic.main.user_layout.*
import kotlinx.android.synthetic.main.user_layout.view.*

/**
 * Created by rishabhkhanna on 12/07/17.
 */

class UserAdapter(private val context: Context,
                  private var users: ArrayList<User>?)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun getItemCount(): Int {
        return users!!.size
//        !! --> if users is null then it will not call users.size, it can be null becoz we have given ?
//        in its declaration which means it can be null


//        val is unmutable, var is mutable
    }

    fun updateUser(newUserList: ArrayList<User>){
        this.users = newUserList
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
            holder!!.bindUser(users!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        val li = LayoutInflater.from(parent!!.context)
        val view = li.inflate(R.layout.user_layout,parent,false)
        return UserViewHolder(view)
    }


    inner class UserViewHolder(
            public var thisView: View
    ):RecyclerView.ViewHolder(thisView){

        fun bindUser(user: User){
            thisView.tvName.text = user.name
            thisView.tvUsername.text = user.username
            thisView.tvEmail.text = user.email
            thisView.tvPhone.text = user.phone
            thisView.setOnClickListener {
                val i = Intent(context,PostActiivty::class.java)
                i.putExtra("id",user.id)
                context.startActivity(i)
            }
        }
    }

}
