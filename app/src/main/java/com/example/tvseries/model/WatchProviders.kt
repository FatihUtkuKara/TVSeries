package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class WatchProviders (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null

)