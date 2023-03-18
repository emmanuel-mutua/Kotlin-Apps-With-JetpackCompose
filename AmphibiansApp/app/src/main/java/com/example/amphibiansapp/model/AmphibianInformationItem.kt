package com.example.amphibiansapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianInformationItem(
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String,
    val name: String,
    val type: String
)