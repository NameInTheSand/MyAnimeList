package com.example.myanimelist.data.repositories

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.myanimelist.data.room.AppRoomDatabase

@SuppressLint("StaticFieldLeak")
object RepositoriesLocator {

    private lateinit var context: Context

    private val database by lazy(mode = LazyThreadSafetyMode.NONE) {
        Room.databaseBuilder(context, AppRoomDatabase::class.java, "animeList").build()
    }

    val animeRepository by lazy {
        RoomAnimeRepository(database.getAnimeDao())
    }

    fun setContext(context: Context) {
        RepositoriesLocator.context = context
    }

}