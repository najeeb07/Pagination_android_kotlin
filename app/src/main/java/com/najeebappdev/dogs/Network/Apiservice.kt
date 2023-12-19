package com.najeebappdev.dogs.Network

import com.najeebappdev.dogs.Data.Dogs
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiservice {
    companion object{
        const val BASE_URL = "https://api.thedogapi.com"
    }

    @GET("v1/images/search")
    suspend fun getAllDogs(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ):List<Dogs>



}