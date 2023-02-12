package com.example.android.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.android.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel(){
    //A StateFlow can be exposed from the GameUiState so that the composables can listen for UI state updates
    // and make the screen state survive configuration changes.

    //stateflow is ued to listen to the ui state and updates
        private val _uiState = MutableStateFlow(GameUiState())
    //backing property for the _uiState to avoid change of state from other classes
    //as stateFlow() makes it mutable state flow a read only state flow
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

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
init {
    resetGame()
}


}