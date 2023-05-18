package com.example.tvseries.retrofit

import com.example.tvseries.retrofit.RetrofitClient

object ApiUtils {
    private const val BaseUrl = "https://mdblist.p.rapidapi.com/"

    fun getSeriesDaoInterface(): SeriesDaoInterface {
        return RetrofitClient.getClient(BaseUrl)!!.create(SeriesDaoInterface::class.java)
    }
}