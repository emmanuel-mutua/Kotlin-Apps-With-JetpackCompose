package com.example.coroutines.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.SerialName
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .build()


interface NetworkService{
    @GET("photos")
    suspend fun getPhotos() : List<GetPhotos>

    @GET("comments")
    suspend fun getComments():List<GetComments>

    @GET("posts")
    suspend fun getPosts():List<GetPosts>

}

//expose the retrofit
object PhotosApi{
    val retrofitService: NetworkService by lazy { retrofit.create(NetworkService::class.java) }
}