package com.example.resources.ui.theme

import com.example.resources.model.*
import com.example.resources.model.users.Users

sealed interface UiState {
    data class Success(
        val users: Users,
        val albums: Albums,
        val photos: Photos,
        val posts: Posts,
        val comments: Comments,
        val todos: Todos
    ) : UiState
    object Loading : UiState
    object Error : UiState

}