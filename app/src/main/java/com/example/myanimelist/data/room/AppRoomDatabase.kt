package com.example.myanimelist.data.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.myanimelist.data.room.AnimeDbEntity.Companion.TABLE_NAME
import com.example.myanimelist.data.room.AppRoomDatabase.AutoMigrationFromOneToTwo

@Database(
    entities = [AnimeDbEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = AutoMigrationFromOneToTwo::class
        )
    ]
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getAnimeDao(): AnimeDao

    @RenameColumn(tableName = TABLE_NAME, fromColumnName = "rating", toColumnName = "userRating")
    class AutoMigrationFromOneToTwo : AutoMigrationSpec

}