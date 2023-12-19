package com.najeebappdev.dogs.Data

import com.squareup.moshi.Json

data class Dogs(

    @Json(name= "url")
    val url:String?
)