package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface ApplicationContainer {
    val amphibianRepository : AmphibianRepository
}

class DefaultApplicationContainer: ApplicationContainer{

    //setting up retrofit
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val retrofitService : AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

    override val amphibianRepository: AmphibianRepository by lazy {
        NetworkAmphibianRepository(retrofitService)
    }

}
