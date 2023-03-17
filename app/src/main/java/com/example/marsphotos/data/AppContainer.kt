package com.example.marsphotos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import kotlinx.serialization.json.Json


import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotoRepository : MarsPhotosRepository
}

class DefaultAppContainer: AppContainer{



    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */


       private val retrofitService: MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }

    override val marsPhotoRepository: MarsPhotosRepository by lazy {
        DefaultMarsPhotoRepository(retrofitService)
    }

    }





