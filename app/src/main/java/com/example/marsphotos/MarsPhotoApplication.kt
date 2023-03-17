package com.example.marsphotos

import android.app.Application
import com.example.marsphotos.data.AppContainer
import com.example.marsphotos.data.DefaultAppContainer

//setting up dependency injection framework
class MarsPhotoApplication : Application(){

    //late init means that the container will be initialized after some time/ not immediately at the start up
        lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}