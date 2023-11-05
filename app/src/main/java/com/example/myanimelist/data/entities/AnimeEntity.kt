package com.example.myanimelist.data.entities

data class AnimeEntity(
    val name: String,
    val creationTime: Long,
    val review: String,
    val genre: String,
    val year: Int,
    val rating: Int
)