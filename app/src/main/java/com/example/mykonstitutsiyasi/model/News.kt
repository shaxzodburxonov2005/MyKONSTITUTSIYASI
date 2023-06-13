package com.example.mykonstitutsiyasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News (
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    @ColumnInfo(name = "name_tittle")
    var nameTitle:String?=null,
    @ColumnInfo(name ="keyDp_id" )
    var keyDpId:Int?=null,
        )