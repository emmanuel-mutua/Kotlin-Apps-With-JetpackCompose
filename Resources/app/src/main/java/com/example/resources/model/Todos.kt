package com.example.resources.model

data class Todos(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)