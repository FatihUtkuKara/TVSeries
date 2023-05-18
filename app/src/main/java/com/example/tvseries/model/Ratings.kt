package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class Ratings (

  @SerializedName("source"  ) var source  : String? = null,
  @SerializedName("value"   ) var value   : Double? = null,
  @SerializedName("score"   ) var score   : Int?    = null,
  @SerializedName("votes"   ) var votes   : Int?    = null,
  @SerializedName("popular" ) var popular : Int?    = null

)