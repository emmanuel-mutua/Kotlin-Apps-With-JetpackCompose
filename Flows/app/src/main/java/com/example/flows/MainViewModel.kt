package com.example.flows

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var text by mutableStateOf("")

    val countDownFlow = flow<Int> {
        var currentValue = 10
        emit(currentValue)
        while (currentValue > 0){
            delay(1000)
            currentValue --
            emit(currentValue)
        }

    }

    private fun collectState(){
        viewModelScope.launch {
            //collectLatest = good for Ui changes
            countDownFlow.collect{
                time ->
                text = if (time == 0){
                    "Time Out"
                }else{
                    time.toString()
                }
            }
        }
    }

    init {
        collectState()
    }


}