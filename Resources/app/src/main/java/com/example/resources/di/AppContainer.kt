package com.example.resources.di

import android.app.Application
import com.example.resources.data.AppContainer
import com.example.resources.data.DefaultAppContainer

class ApplicationContainer : Application(){

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}