package com.example.mykonstitutsiyasi.keydp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.mykonstitutsiyasi.model.Category
import com.example.mykonstitutsiyasi.model.CategoryNews

@Dao
interface CategoryDao {
    @Transaction
    @Query("select * from category")
    fun getCategoryByNews():List<CategoryNews>

    @Query("select * from category")
    fun getAllCategory():List<Category>

    @Insert
    fun insertCategory(category: Category)

    @Insert
    fun insertCategoryAll(category: List<Category>)
}