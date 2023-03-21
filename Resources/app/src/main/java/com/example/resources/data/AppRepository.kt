package com.example.resources.data

import com.example.resources.model.Albums
import com.example.resources.model.Photos
import com.example.resources.model.Posts
import com.example.resources.model.Todos
import com.example.resources.model.users.Users
import com.example.resources.network.NetApiService


interface AppRepository {
    suspend fun getUsers(): List<Users>

    suspend fun getPosts() : List<Posts>

    suspend fun getPhotos() : List<Photos>

    suspend fun getAlbums() : List<Albums>

    suspend fun getTodos(): List<Todos>
}
class DefaultAppRepository(
    val retrofitApiService: NetApiService
) : AppRepository{
    override suspend fun getUsers(): List<Users> = retrofitApiService.getUsers()

    override suspend fun getPosts(): List<Posts> = retrofitApiService.getPosts()

    override suspend fun getPhotos(): List<Photos> = retrofitApiService.getPhotos()

    override suspend fun getAlbums(): List<Albums> = retrofitApiService.getAlbums()

    override suspend fun getTodos(): List<Todos> = retrofitApiService.getTodos()

}