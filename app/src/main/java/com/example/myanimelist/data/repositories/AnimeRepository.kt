package com.example.myanimelist.data.repositories

import com.example.myanimelist.data.entities.AnimeEntity
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    suspend fun getAnimeList(): Flow<List<AnimeEntity>>

    suspend fun insertAnime(animeEntity: AnimeEntity)

    suspend fun updateAnime(animeEntity: AnimeEntity)

    suspend fun searchAnime(name:String): Flow<List<AnimeEntity>>
}