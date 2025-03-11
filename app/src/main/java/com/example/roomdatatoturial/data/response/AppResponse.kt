package com.example.roomdatatoturial.data.response

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.roomdatatoturial.data.entity.Contact

  data class AppResponse(
    var loading:Boolean=false,
    var allContact:List<Contact>  =emptyList<Contact>(),
    var success:Boolean=false,
    var error:String="",
    var id:MutableState<Int> = mutableStateOf(0),
    var name: MutableState<String> = mutableStateOf(""),
    var mobileNumber: MutableState<String> = mutableStateOf(""),
    var email: MutableState<String> = mutableStateOf(""),

    )