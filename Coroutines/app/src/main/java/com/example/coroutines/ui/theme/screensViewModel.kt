package com.example.coroutines.ui.theme


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException

const val TAG = "MainActivity"

sealed interface PhotosUiState{
    data class Success(val photos: String) :PhotosUiState
    object Error: PhotosUiState
    object Loading: PhotosUiState
}
class RetrofitViewModel : ViewModel(){
    var photosUiState: PhotosUiState by mutableStateOf(PhotosUiState.Loading)
        private set
    //Private set indicates that the PhotoUiState can be modified within the class that declared it

    private fun getPhotos(){
        viewModelScope.launch{

            photosUiState = try {
                val resultList = async { PhotosApi.retrofitService.getPhotos() }
                val commentResult = async { PhotosApi.retrofitService.getComments() }
                val postsList = async { PhotosApi.retrofitService.getPosts() }
                // .await() is used to wait for results from the Launched coroutines
                PhotosUiState.Success("Success ${resultList.await().size} photos retrieved \n and ${commentResult.await().size} comments" +
                        "\n Success: ${postsList.await().size}")

            }catch (e: IOException){
                PhotosUiState.Error
            }


        }
    }
    init {
        getPhotos()
    }

}