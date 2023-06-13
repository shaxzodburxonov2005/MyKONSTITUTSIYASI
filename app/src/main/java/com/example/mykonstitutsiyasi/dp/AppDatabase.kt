package com.example.mykonstitutsiyasi.dp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mykonstitutsiyasi.keydp.CategoryDao
import com.example.mykonstitutsiyasi.keydp.NewsDao
import com.example.mykonstitutsiyasi.model.Category
import com.example.mykonstitutsiyasi.model.News

@Database(entities = [News::class,Category::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun newsDao():NewsDao
    abstract fun category():CategoryDao

    companion object{
        private var instance:AppDatabase?=null
        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instance==null){
                instance=Room.databaseBuilder(context,AppDatabase::class.java,"news.dp")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}