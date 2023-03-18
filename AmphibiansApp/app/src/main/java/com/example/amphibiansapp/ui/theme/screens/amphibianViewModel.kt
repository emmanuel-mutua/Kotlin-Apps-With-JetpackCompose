package com.example.amphibiansapp.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.data.AmphibianRepository
import com.example.amphibiansapp.di.AmphibianApplication
import com.example.amphibiansapp.model.AmphibianInformationItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibianUiState{
    data class Success(val amphibianInformation: List<AmphibianInformationItem>) : AmphibianUiState
    object Loading: AmphibianUiState
    object Error : AmphibianUiState
}

class AmphibianViewModel(private val amphibianRepository : AmphibianRepository) : ViewModel(){

 var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
    private set

    init {
        getAmphibianInformation()
    }
    fun getAmphibianInformation(){
        viewModelScope.launch {
            amphibianUiState = try {
                val result = amphibianRepository.getAmphibianInfo()
                println("Result : $result")
                AmphibianUiState.Success(result)
            }catch (e: IOException){
                AmphibianUiState.Error
            }catch (e: HttpException){
                AmphibianUiState.Error
            }
        }
    }
    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val  amphibianRepository = application.container.amphibianRepository
                AmphibianViewModel(amphibianRepository = amphibianRepository)

            }
        }
    }
}