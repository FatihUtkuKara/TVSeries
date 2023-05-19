package com.example.tvseries

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    private lateinit var ratingBar : RatingBar
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var npsButton : Button
    private lateinit var point : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        sharedPreferences = getSharedPreferences("rating",Context.MODE_PRIVATE)
        npsButton = findViewById(R.id.saveNps)
        point = findViewById(R.id.point)

        ratingBar.setOnRatingBarChangeListener{_,rating,_ ->
            sharedPreferences.edit().putFloat("userRating",rating).apply()
        }
        npsButton.setOnClickListener() {
            Toast.makeText(this,"Your rating has been saved",Toast.LENGTH_SHORT).show()
            Log.e("xxx", ratingBar.rating.toString())
            point.setText("Your rating for this series " +ratingBar.rating.toString())
        }
    }
}