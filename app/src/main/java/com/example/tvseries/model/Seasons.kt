package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class Seasons (

  @SerializedName("tmdbid"        ) var tmdbid       : Int?    = null,
  @SerializedName("name"          ) var name         : String? = null,
  @SerializedName("air_date"      ) var airDate      : String? = null,
  @SerializedName("episode_count" ) var episodeCount : Int?    = null,
  @SerializedName("season_number" ) var seasonNumber : Int?    = null,
  @SerializedName("tomatofresh"   ) var tomatofresh  : String? = null,
  @SerializedName("poster_path"   ) var posterPath   : String? = null

)