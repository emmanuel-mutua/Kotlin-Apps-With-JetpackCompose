package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.AmphibianInformationItem
import com.example.amphibiansapp.network.AmphibianApiService

interface AmphibianRepository {
  suspend fun getAmphibianInfo() : List<AmphibianInformationItem>
}

class NetworkAmphibianRepository(private val amphibianApiService: AmphibianApiService): AmphibianRepository{
    override suspend fun getAmphibianInfo(): List<AmphibianInformationItem> {
            return amphibianApiService.getAmphibians()
    }

}