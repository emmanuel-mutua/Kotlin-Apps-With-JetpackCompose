package com.example.resources.network

import com.example.resources.model.*
import com.example.resources.model.users.Users
import retrofit2.http.GET

interface NetApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>

    @GET("posts")
    suspend fun getPosts() : List<Posts>

    @GET("photos")
    suspend fun getPhotos() : List<Photos>

    @GET("albums")
    suspend fun getAlbums() : List<Albums>

    @GET("todos")
    suspend fun getTodos(): List<Todos>

}