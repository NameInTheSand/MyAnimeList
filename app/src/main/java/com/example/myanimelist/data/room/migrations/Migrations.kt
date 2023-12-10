package com.example.myanimelist.data.room.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myanimelist.data.room.AnimeDbEntity.Companion.TABLE_NAME

object Migrations {

    val MIGRATION_2_3 = object : Migration(2,3){

        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE $TABLE_NAME add seriesCount VARCHAR default 12 NOT NULL")
        }

    }

}