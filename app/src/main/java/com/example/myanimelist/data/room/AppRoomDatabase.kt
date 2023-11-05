package com.example.myanimelist.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myanimelist.data.room.AnimeDbEntity

@Database(
    entities = [AnimeDbEntity::class],
    version = 1
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getAnimeDao(): AnimeDao

}