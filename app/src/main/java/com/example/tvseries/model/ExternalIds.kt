package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class ExternalIds (

  @SerializedName("imdb"            ) var imdb           : Imdb?     = Imdb(),
  @SerializedName("tmdb"            ) var tmdb           : Tmdb?     = Tmdb(),
  @SerializedName("iva"             ) var iva            : Iva?      = Iva(),
  @SerializedName("facebook"        ) var facebook       : String?   = null,
  @SerializedName("rotten_tomatoes" ) var rottenTomatoes : String?   = null,
  @SerializedName("wiki_data"       ) var wikiData       : WikiData? = WikiData(),
  @SerializedName("iva_rating"      ) var ivaRating      : String?   = null,
  @SerializedName("gracenote"       ) var gracenote      : String?   = null

)