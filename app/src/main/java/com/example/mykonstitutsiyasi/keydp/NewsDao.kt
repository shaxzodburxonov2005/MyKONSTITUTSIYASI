package com.example.mykonstitutsiyasi.keydp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.mykonstitutsiyasi.model.CategoryNews
import com.example.mykonstitutsiyasi.model.News

@Dao
interface NewsDao {
    @Insert
    fun addNews(news: News)



}