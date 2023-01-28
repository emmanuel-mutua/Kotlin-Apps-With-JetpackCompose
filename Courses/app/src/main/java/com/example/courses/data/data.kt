package com.example.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameRsId: Int,
     val numId: Int,
    @DrawableRes val imageRsId: Int,
)