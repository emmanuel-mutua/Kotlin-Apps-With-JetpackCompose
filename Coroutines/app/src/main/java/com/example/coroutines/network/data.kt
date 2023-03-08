package com.example.coroutines.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//convert to string using serialization
@Serializable
data class GetPhotos(
    val albumId: Int,
    val id: Int,
    val title: String,
    @SerialName(value = "url")
    val url : String,
    val thumbnailUrl: String
)

@Serializable
data class GetComments(
    val postId: Int,
    val id: Int,
    @SerialName(value = "name")
    val name : String,
    val email: String,
    val body: String
)

@Serializable
data class GetPosts(
    val userId: Int,
    val Id : Int,
    @SerialName(value = "title")
    val title: String,
    val body: String
)