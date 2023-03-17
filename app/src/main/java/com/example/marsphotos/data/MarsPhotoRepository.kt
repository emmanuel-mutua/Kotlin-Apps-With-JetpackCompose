package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto

//modify data, receive the data, expose it to other layers of the app
//interface is used to define how the repository will be implemented
//in our case only one fun = getMarsPhotos will be implemented on the repo
interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

//this class needs an instance(object) of DefaultAppContainer.MarsApiService
class DefaultMarsPhotoRepository(private val marsApiService: MarsApiService) :
    MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }

}
