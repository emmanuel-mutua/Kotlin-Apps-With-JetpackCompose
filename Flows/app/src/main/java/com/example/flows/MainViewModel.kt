package com.example.flows

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    var hour by mutableStateOf("02d".format())
    var minute by mutableStateOf("02d".format())
    var sec by mutableStateOf("02d".format())

    init {
        initializeTime()
    }
    private fun initializeTime(){
        viewModelScope.launch {
            launch {
                genHourFlow().collect {
                    hour = it.toString()
                }
            }

            launch {
                genMinFlow().collect {
                    minute = it.toString()
                }
            }

            launch {
                genSecFlow().collect {
                    sec = it.toString()
                }
            }

        }
    }
    private fun genHourFlow():  Flow<Int>{
        return flow {
            var initial = 0
            while (initial < 24){
                delay(3600000)
                emit(initial)
            }
        }
    }

    private fun genMinFlow(): Flow<Int>{
        return flow {
            var initial = 0
            while (initial < 60){
                delay(60000)
                emit(initial)
            }
        }
    }
    private fun genSecFlow(): Flow<Int>{
        return flow {
            var initial = 0
            while (initial < 60){
                delay(1000)
                initial ++
                emit(initial)
            }
        }
    }

}

//flow Operator = can transform emissions
//a flow is a type that emit multiple values sequentially
//flow can be used to emit live data from the database
//you need to deep dive into lists