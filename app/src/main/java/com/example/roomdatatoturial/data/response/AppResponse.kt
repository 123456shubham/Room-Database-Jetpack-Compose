package com.example.roomdatatoturial.data.response

import com.example.roomdatatoturial.data.entity.Contact

 class AppResponse(
    var loading:Boolean=false,
    var allContact:List<Contact>  =emptyList<Contact>(),
    var success:Boolean=false,
    var error:String="",
    )