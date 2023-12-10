package com.example.myanimelist.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.myanimelist.data.entities.AnimeEntity
import com.example.myanimelist.data.room.AnimeDbEntity.Companion.TABLE_NAME


@Entity(
    tableName = TABLE_NAME,
    indices = [Index("name", unique = true)]
)
data class AnimeDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val name: String,
    @ColumnInfo(name = "created_at") val creationTime: Long,
    val review: String,
    val genre: String,
    val year: Int,
    val userRating: Int,
    @ColumnInfo(defaultValue = "12") val seriesCount: Int
) {

    fun toAnimeEntity(): AnimeEntity {
        return AnimeEntity(
            name = this.name,
            creationTime = this.creationTime,
            review = this.review,
            genre = this.genre,
            year = this.year,
            userRating = this.userRating,
            seriesCount = this.seriesCount
        )
    }

    companion object {

        const val TABLE_NAME = "anime"

        fun AnimeEntity.fromAnimeEntity(): AnimeDbEntity {
            return AnimeDbEntity(
                id = 0,
                name = this.name,
                creationTime = this.creationTime,
                review = this.review,
                genre = this.genre,
                year = this.year,
                userRating = this.userRating,
                seriesCount = this.seriesCount
            )
        }

    }

}
