package com.goldendevs.testapplication.apiservices

import com.goldendevs.testapplication.model.DataResponse
import retrofit2.Call
import retrofit2.http.*

interface ItunesServices {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    fun getMovies(): Call<DataResponse>

}