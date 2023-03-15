package com.example.flows

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


data class NewsRemoteDataSource(
    val newsApi: NewsApi,
    val refreshSource: Long = 5000
){
        val latestNews : Flow<List<Articles>> = flow {
            while (true){
                //latestNews = newsApi.getNews()
            }
        }

}

interface NewsApi{
    suspend fun getNews() : List<Articles>
}

data class Articles(
    val id : Int,
    val title: String
)
class LearningViewModel : ViewModel(){

//mutable
    //state holder and shows the current value, latest updates
    //can gen values
    private var _stateFlow = MutableStateFlow(0)
    //immutable
    val stateFlow = _stateFlow.asStateFlow()


    fun incrementFlow(){
        _stateFlow.value += 1
    }

    var text by mutableStateOf("")
    private val countDownFlow = flow<Int> {
        var currentValue = 20
        emit(currentValue)
        while (currentValue > 0){
            delay(1000)
            currentValue --
            emit(currentValue)
        }

    }

    val updownFlow = flow<Int> {
        val initialVal = 0
        var currentVal = initialVal
        emit(currentVal)
        while (currentVal < 100){
            delay(1000L)
            currentVal --
            emit(currentVal)


        }
    }


    //terminal operators
    private fun collectState1(){
        viewModelScope.launch {
            //adding all the emissions
            val reduceResult = countDownFlow.reduce{
                    accumulator,value ->
                accumulator + value
            }
            val foldResult = countDownFlow
                .fold(100){
                        accumulator,value ->
                    accumulator + value
                }
            //you want to do a certain transformation
            val mapRes = countDownFlow.map {
                    time ->
                time + time
            }
            println("The value is reduce : $reduceResult")
            println("The value is folded : $foldResult")
        }
    }

    private fun collectState(){
        viewModelScope.launch {
            //collectLatest = good for Ui changes
            countDownFlow
                .collectLatest { time ->
                    text = time.toString()
                    if (time == 0){
                        text = "Time Out"
                    }
                }



        }

    }

    init {
        collectState()
    }

    init {
        squareNumber(3)
        viewModelScope.launch {
            sharedFlow.collect{
                println("First Flow emits $it")
                delay(1000)
            }
        }
        viewModelScope.launch {
            sharedFlow.collect{
                println("First Flow emits $it")
            }
        }

    }

    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    private fun squareNumber(number : Int){
        viewModelScope.launch {
            _sharedFlow.emit(number * number)
        }
    }


}

//flow Operator = can transform emissions
//a flow is a type that emit multiple values sequentially
//flow can be used to emit live data from the database
//you need to deep dive into lists
//stateflow means to keep the state
//it can notify changes
//shared flow = used to send one time events like for example if you are navigating from the login to the dashboard page  and then
//you need to notify fragment to navigate, login success msg
//shared flow = receiving events