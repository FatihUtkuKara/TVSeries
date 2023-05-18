package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class SeriesInfo (

  @SerializedName("variant"     ) var variant    : String?            = null,
  @SerializedName("results"     ) var results    : ArrayList<Results> = arrayListOf(),
  @SerializedName("updated"     ) var updated    : String?            = null,
  @SerializedName("term"        ) var term       : String?            = null,
  @SerializedName("status_code" ) var statusCode : Int?               = null

)