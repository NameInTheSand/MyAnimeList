package com.example.myanimelist.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myanimelist.data.room.AnimeDbEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow


@Dao
interface AnimeDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY created_at asc")
    fun getAnimeList(): Flow<List<AnimeDbEntity>>

    @Insert
    suspend fun insertEntity(animeDbEntity: AnimeDbEntity)

    @Update
    suspend fun updateEntity(animeDbEntity: AnimeDbEntity)

    @Query("SELECT * FROM $TABLE_NAME WHERE name LIKE :name")
    fun getAnimeByName(name: String): Flow<List<AnimeDbEntity>>

}