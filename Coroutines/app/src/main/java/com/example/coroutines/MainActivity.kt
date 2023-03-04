package com.example.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutines.ui.theme.CoroutinesTheme
import kotlinx.coroutines.*

const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesTheme{
                var text by remember {
                    mutableStateOf("Text ...")
                }
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        Text(text = text)
                    }
                    }

               val job =  GlobalScope.launch(Dispatchers.Default) {

              for (i in 20..60){
                  if(isActive){
                      Log.d(TAG, "i = $i")
                  }

              }
                }

                runBlocking {
                //cancelling main thread and executing after the coroutine job has finished
                    delay(1000L)
                    job.cancel()
                    Log.d(TAG, "Job Canceld")
                    Log.d(TAG, "main thread ${Thread.currentThread().name}")

                }

            }
        }
    }


    suspend fun doNetWorkCal2l(): String{
        delay(1000)
        return "Work Done 2"
    }
}


/**
 *  LaunchedEffect(Unit){
withContext(Dispatchers.Main){
text2 = doNetWorkCal2l()
}

GlobalScope.launch(Dispatchers.IO) {
Log.d(TAG, "Network call start executing on ${Thread.currentThread().name}")
val ans1 = doNetWorkCall()
withContext(Dispatchers.Main){
text = ans1
}
}
}
 */