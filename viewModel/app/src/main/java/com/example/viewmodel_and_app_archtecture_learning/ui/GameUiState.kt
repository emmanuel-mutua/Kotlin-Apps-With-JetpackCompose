package com.example.viewmodel_and_app_archtecture_learning.ui

data class GameUiState(
    val CurrentScrambleWord: String = "",
    val currentWordCount: Int = 0,
val isGuessedWordWrong : Boolean =false,
    val score : Int = 0,
    val isGameOver: Boolean = false

)