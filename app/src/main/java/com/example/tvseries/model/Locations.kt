package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class Locations (

  @SerializedName("display_name" ) var displayName : String? = null,
  @SerializedName("id"           ) var id          : String? = null,
  @SerializedName("url"          ) var url         : String? = null,
  @SerializedName("name"         ) var name        : String? = null,
  @SerializedName("icon"         ) var icon        : String? = null

)