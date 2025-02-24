package com.example.roomdatatoturial.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String="",
    var email:String="",
    var phone:String="",

)
