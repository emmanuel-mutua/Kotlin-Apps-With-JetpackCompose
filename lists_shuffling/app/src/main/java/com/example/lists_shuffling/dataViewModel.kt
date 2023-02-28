package com.example.lists_shuffling

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DataViewModel: ViewModel(){
    fun getLists() = emojis
    fun shuffleEmoji() = emojis.shuffled()

}