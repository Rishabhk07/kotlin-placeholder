package com.codingblocks.kotlinplaceholder.model

/**
 * Created by rishabhkhanna on 12/07/17.
 */

data class Comment(
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
)
