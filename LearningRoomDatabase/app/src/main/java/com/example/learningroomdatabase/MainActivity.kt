package com.example.learningroomdatabase


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.learningroomdatabase.screens.*
import com.example.learningroomdatabase.ui.theme.LearningRoomDatabaseTheme

class MainActivity : ComponentActivity() {

private val database by lazy {
    Room.databaseBuilder(
        applicationContext,NumbersDatabase::class.java, "numbers_db"
    ).fallbackToDestructiveMigration()
        .build()
}

    private val viewModel by viewModels<NumbersViewModel>(
        factoryProducer = {
           object : ViewModelProvider.Factory{
               override fun <T : ViewModel> create(modelClass: Class<T>): T {
                   return NumbersViewModel(database.numbersDao, this@MainActivity) as T
               }
           }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningRoomDatabaseTheme {
                val state by viewModel.state.collectAsState()
                MainScreen(state, viewModel :: onEvent)
            }
        }
    }
}


