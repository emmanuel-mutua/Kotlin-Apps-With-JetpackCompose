package com.example.coroutines

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.coroutines.ui.theme.CoroutinesTheme
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val TAG = "MainActivity"
const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesTheme {

                Surface(Modifier.fillMaxSize()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { }) {
                            Text(text = "Start Activity")
                        }
                    }
                }

                val api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MyApi::class.java)

                    GlobalScope.launch {
                        val commets = api.getComments().await()
                        for (comment in commets){
                            Log.d(TAG, "${comment.toString()}")
                        }
                    }
            }
        }
    }


}

data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int

)

interface MyApi{
    @GET("/comments")
    fun getComments():Call<List<Comment>>
}

