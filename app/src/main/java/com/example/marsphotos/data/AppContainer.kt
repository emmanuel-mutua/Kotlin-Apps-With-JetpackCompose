package com.example.marsphotos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import com.example.marsphotos.model.MarsPhoto
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

//defining the objects needed in the marsPhotoRepository
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
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    interface MarsApiService {
        @GET("photos")
        suspend fun getPhotos(): List<MarsPhoto>
    }

    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     * by lazy means that it will be active when it is initialized
     */

       private val retrofitService: MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }

    override val marsPhotoRepository: MarsPhotosRepository by lazy {
        DefaultMarsPhotoRepository(retrofitService)
    }

    }





