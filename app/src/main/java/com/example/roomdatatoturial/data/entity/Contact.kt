package com.example.roomdatatoturial.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String="",
    var email:String="",
    var phone:String="",
    @ColumnInfo(name="createdAt",defaultValue = "0")
    var createdAt:Long=System.currentTimeMillis()

)
