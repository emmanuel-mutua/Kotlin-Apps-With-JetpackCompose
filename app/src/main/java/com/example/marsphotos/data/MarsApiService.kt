package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import retrofit2.http.GET


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
