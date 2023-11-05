package com.example.myanimelist.data.repositories

import com.example.myanimelist.data.entities.AnimeEntity
import com.example.myanimelist.data.room.AnimeDao
import com.example.myanimelist.data.room.AnimeDbEntity
import com.example.myanimelist.data.room.AnimeDbEntity.Companion.fromAnimeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RoomAnimeRepository(
    private val animeDao: AnimeDao
) : AnimeRepository {

    override suspend fun getAnimeList(): Flow<List<AnimeEntity>> = withContext(Dispatchers.IO) {
        return@withContext animeDao.getAnimeList().map { anime: List<AnimeDbEntity> ->
            anime.map {
                it.toAnimeEntity()
            }
        }
    }

    override suspend fun insertAnime(animeEntity: AnimeEntity) = withContext(Dispatchers.IO) {
        animeDao.insertEntity(animeEntity.fromAnimeEntity())
    }

    override suspend fun updateAnime(animeEntity: AnimeEntity) = withContext(Dispatchers.IO) {
        animeDao.insertEntity(animeEntity.fromAnimeEntity())
    }

    override suspend fun searchAnime(
        name: String
    ): Flow<List<AnimeEntity>> = withContext(Dispatchers.IO) {
        return@withContext animeDao.getAnimeByName(name).map { anime: List<AnimeDbEntity> ->
            anime.map {
                it.toAnimeEntity()
            }
        }
    }

}