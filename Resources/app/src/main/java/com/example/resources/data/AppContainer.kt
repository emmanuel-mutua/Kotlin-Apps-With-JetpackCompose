package com.example.resources.data

import com.example.resources.network.NetApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

//setting up retrofitService

interface AppContainer {
    val appRepository : AppRepository
}

class DefaultAppContainer : AppContainer{
    val BASE_URL = "https//"

    val retrofit  = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()

    val retrofitService : NetApiService by lazy {
        retrofit.create(NetApiService ::class.java)
    }
    override val appRepository: AppRepository by lazy{
        DefaultAppRepository(retrofitService)
    }
}



