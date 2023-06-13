package com.example.mykonstitutsiyasi.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Category(
    var name: String?=null,
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    ) : Serializable
