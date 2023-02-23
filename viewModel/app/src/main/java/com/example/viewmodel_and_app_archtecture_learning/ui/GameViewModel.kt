package com.example.viewmodel_and_app_archtecture_learning.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.viewmodel_and_app_archtecture_learning.data.MAX_NO_OF_WORDS
import com.example.viewmodel_and_app_archtecture_learning.data.SCORE_INCREASE
import com.example.viewmodel_and_app_archtecture_learning.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel(){


    //A StateFlow can be exposed from the GameUiState so that the composables can listen for UI state updates
    // and make the screen state survive configuration changes.

    //stateflow is ued to listen to the ui state and updates
    private val _uiState = MutableStateFlow(GameUiState())
    //backing property for the _uiState to avoid change of state from other classes
    //as stateFlow() makes it mutable state flow a read only state flow
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
    private set

    fun checkUserGuess(){
        if(userGuess.equals(currentWord, ignoreCase = true)){
                val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        }else{
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }


    private var _count = 0
    val count: Int
        get() = _count

    //to display the current scrumble word

    private lateinit var currentWord : String
    private var usedWords : MutableSet<String> = mutableSetOf()

    private fun pickRandomWordAndShuffle() :String{
        currentWord = allWords.random()

        if (usedWords.contains(currentWord)){
            return pickRandomWordAndShuffle()
        }
        else{
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord) == (word)){
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame(){
        usedWords.clear()
        _uiState.value = GameUiState(CurrentScrambleWord = pickRandomWordAndShuffle())
    }

    fun updateUserGuess(guessedWord: String) {
         userGuess = guessedWord
    }
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            _uiState.update {
                currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        }else{

            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    CurrentScrambleWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc(),
                )
            }
        }
    }
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }
    init {
    resetGame()
}


}