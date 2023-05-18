package com.example.tvseries.retrofit

import com.example.tvseries.model.SeriesInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SeriesDaoInterface {

    @GET("/")
    fun getSeries(
        @QueryMap queryParams: Map<String, String>
    ): Call<SeriesInfo?>


}