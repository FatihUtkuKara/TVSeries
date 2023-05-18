package com.example.tvseries.model

import com.google.gson.annotations.SerializedName


data class SeriesInfo (
  @SerializedName("title"           ) var title          : String?                   = null,
  @SerializedName("year"            ) var year           : Int?                      = null,
  @SerializedName("released"        ) var released       : String?                   = null,
  @SerializedName("description"     ) var description    : String?                   = null,
  @SerializedName("runtime"         ) var runtime        : Int?                      = null,
  @SerializedName("score"           ) var score          : Int?                      = null,
  @SerializedName("score_average"   ) var scoreAverage   : Int?                      = null,
  @SerializedName("imdbid"          ) var imdbid         : String?                   = null,
  @SerializedName("traktid"         ) var traktid        : Int?                      = null,
  @SerializedName("tmdbid"          ) var tmdbid         : Int?                      = null,
  @SerializedName("type"            ) var type           : String?                   = null,
  @SerializedName("ratings"         ) var ratings        : ArrayList<Ratings>        = arrayListOf(),
  @SerializedName("streams"         ) var streams        : ArrayList<Streams>        = arrayListOf(),
  @SerializedName("watch_providers" ) var watchProviders : ArrayList<WatchProviders> = arrayListOf(),
  @SerializedName("reviews"         ) var reviews        : ArrayList<String>         = arrayListOf(),
  @SerializedName("keywords"        ) var keywords       : ArrayList<Keywords>       = arrayListOf(),
  @SerializedName("language"        ) var language       : String?                   = null,
  @SerializedName("spoken_language" ) var spokenLanguage : String?                   = null,
  @SerializedName("country"         ) var country        : String?                   = null,
  @SerializedName("certification"   ) var certification  : String?                   = null,
  @SerializedName("commonsense"     ) var commonsense    : Int?                      = null,
  @SerializedName("age_rating"      ) var ageRating      : Int?                      = null,
  @SerializedName("status"          ) var status         : String?                   = null,
  @SerializedName("trailer"         ) var trailer        : String?                   = null,
  @SerializedName("poster"          ) var poster         : String?                   = null,
  @SerializedName("backdrop"        ) var backdrop       : String?                   = null,
  @SerializedName("response"        ) var response       : Boolean?                  = null,
  @SerializedName("apiused"         ) var apiused        : Int?                      = null,
  @SerializedName("tvdbid"          ) var tvdbid         : Int?                      = null,
  @SerializedName("seasons"         ) var seasons        : ArrayList<Seasons>        = arrayListOf()


)