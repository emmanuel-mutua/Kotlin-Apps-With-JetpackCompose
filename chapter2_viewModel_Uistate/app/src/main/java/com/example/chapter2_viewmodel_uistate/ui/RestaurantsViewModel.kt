package com.example.chapter2_viewmodel_uistate.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.chapter2_viewmodel_uistate.ui.dummyRestaurants


class RestaurantsViewModel() : ViewModel() {
    fun getRestaurants() = dummyRestaurants
}