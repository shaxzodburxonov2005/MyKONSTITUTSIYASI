package com.example.mykonstitutsiyasi.model

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryNews(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "keyDp_id"

    )
    val list: List<News>
)
