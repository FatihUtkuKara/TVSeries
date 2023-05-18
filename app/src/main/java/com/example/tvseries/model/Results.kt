package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("locations"    ) var locations   : ArrayList<Locations> = arrayListOf(),
  @SerializedName("weight"       ) var weight      : Int?                 = null,
  @SerializedName("id"           ) var id          : String?              = null,
  @SerializedName("external_ids" ) var externalIds : ExternalIds?         = ExternalIds(),
  @SerializedName("picture"      ) var picture     : String?              = null,
  @SerializedName("provider"     ) var provider    : String?              = null,
  @SerializedName("name"         ) var name        : String?              = null

)