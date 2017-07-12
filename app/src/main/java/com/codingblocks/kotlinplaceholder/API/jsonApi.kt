package com.codingblocks.kotlinplaceholder.API



import com.codingblocks.kotlinplaceholder.model.Post
import com.codingblocks.kotlinplaceholder.model.User
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rishabhkhanna on 12/07/17.
 */

interface jsonApi{
    @GET("/users")
    fun getUsers(): Call<ArrayList<User>>

    @GET("/posts")
    fun getUserPosts(
            @Query ("userId") id: String
    ): Call<ArrayList<Post>>
}