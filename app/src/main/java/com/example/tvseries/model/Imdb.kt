package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class Imdb (

  @SerializedName("url" ) var url : String? = null,
  @SerializedName("id"  ) var id  : String? = null

)