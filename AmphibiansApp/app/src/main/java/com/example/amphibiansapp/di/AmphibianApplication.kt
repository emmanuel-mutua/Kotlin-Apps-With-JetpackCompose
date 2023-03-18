package com.example.amphibiansapp.di

import android.app.Application
import com.example.amphibiansapp.data.ApplicationContainer
import com.example.amphibiansapp.data.DefaultApplicationContainer

class AmphibianApplication : Application(){
    lateinit var container : ApplicationContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }

}