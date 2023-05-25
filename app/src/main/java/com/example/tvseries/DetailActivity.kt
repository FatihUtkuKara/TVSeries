package com.example.tvseries

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tvseries.model.SeriesInfo
import com.example.tvseries.retrofit.ApiUtils
import com.example.tvseries.retrofit.SeriesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private var seriesDıf: SeriesDaoInterface? = null

    private lateinit var seriesImage : ImageView
    private lateinit var series: SeriesInfo
    private lateinit var ratingBar : RatingBar
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var npsButton : Button
    private lateinit var point : TextView
    private lateinit var seriesCode : String
    private lateinit var description: TextView
    private lateinit var year: TextView
    private lateinit var streamer: TextView
    private lateinit var country: TextView
    private lateinit var seriesTitle: TextView
    private lateinit var language: TextView
    private lateinit var type: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        seriesDıf = ApiUtils.getSeriesDaoInterface()
        ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        sharedPreferences = getSharedPreferences("rating",Context.MODE_PRIVATE)
        npsButton = findViewById(R.id.saveNps)
        point = findViewById(R.id.point)
        description = findViewById(R.id.description)
        year = findViewById(R.id.year)
        streamer = findViewById(R.id.streamer)
        country = findViewById(R.id.country)
        seriesTitle = findViewById(R.id.seriesTitle)
        language = findViewById(R.id.language)
        type = findViewById(R.id.type)
        seriesImage = findViewById(R.id.seriesImage)



        if (intent.hasExtra("seriesCode")) {
            seriesCode = intent.getStringExtra("seriesCode")!!
        }

        getSeries()
        ratingBar.setOnRatingBarChangeListener{_,rating,_ ->
            sharedPreferences.edit().putFloat("userRating",rating).apply()
        }
        npsButton.setOnClickListener() {
            Toast.makeText(this,"Your rating has been saved",Toast.LENGTH_SHORT).show()
            Log.e("rating", ratingBar.rating.toString())
            point.setText("Your rating : " +ratingBar.rating.toString())
        }


    }

    fun getSeries() {

        val idsMap = mutableMapOf<String, String>()
        idsMap["i"] = seriesCode
        idsMap["rapidapi-key"] = "937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574"


        seriesDıf!!.getSeries(idsMap)!!.enqueue(object : Callback<SeriesInfo?> {

            override fun onResponse(call: Call<SeriesInfo?>, response: Response<SeriesInfo?>) {
                series = response.body()!!
                populateUI()



            }

            override fun onFailure(call: Call<SeriesInfo?>, t: Throwable) {

            }
        })
    }

    fun populateUI(){
        description.setText(series.description)
        if(!series.year.toString().isNullOrEmpty()) {
            year.setText(series.year!!.toString())
        }
        streamer.setText(series.streams[0].name)
        country.setText(series.country)
        seriesTitle.setText(series.title)
        language.setText(series.language)
        type.setText(series.type)
        Glide.with(applicationContext).load(series.poster).into(seriesImage)

    }
}