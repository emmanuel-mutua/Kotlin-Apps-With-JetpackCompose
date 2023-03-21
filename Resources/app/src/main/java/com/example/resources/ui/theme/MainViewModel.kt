package com.example.resources.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.resources.data.AppRepository
import com.example.resources.di.ApplicationContainer

class MainViewModel(private val userDataRepository: AppRepository) : ViewModel(){



    /**
     * Factory for [MainViewModel] that takes [Repository] as a dependency
     */
    companion object{
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ApplicationContainer)
                val userDataRepository = application.container.userDataRepository
                MainViewModel(userDataRepository = userDataRepository)
            }
        }
    }

}