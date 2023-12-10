package com.example.myanimelist.data.repositories

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.myanimelist.data.room.AppRoomDatabase
import com.example.myanimelist.data.room.migrations.Migrations.MIGRATION_2_3

@SuppressLint("StaticFieldLeak")
object RepositoriesLocator {

    private lateinit var context: Context

    private val database by lazy(mode = LazyThreadSafetyMode.NONE) {
        Room.databaseBuilder(context, AppRoomDatabase::class.java, "animeList")
            .addMigrations(MIGRATION_2_3).build()
    }

    val animeRepository by lazy {
        RoomAnimeRepository(database.getAnimeDao())
    }

    fun setContext(context: Context) {
        RepositoriesLocator.context = context
    }

}