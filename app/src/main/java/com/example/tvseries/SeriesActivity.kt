package com.example.tvseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.collections.ArrayList

class SeriesActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    private lateinit var seriesList : ArrayList<Series>
    private lateinit var adapter: SeriesActivityRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        rv = findViewById(R.id.seriesRv)

        rv.setHasFixedSize(true)

        rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val series1 = Series(1,"peakyBlinders","tt2442560")
        val series2 = Series(2,"office","tt0386676")
        val series3 = Series(3,"himym","tt0460649")
        val series4 = Series(4,"breakingBad","tt0903747")
        val series5 = Series(5,"gameOfThrones","tt0944947")
        val series6 = Series(6,"vikings","tt2306299")
        val series7 = Series(7,"afterLife","tt8398600")
        val series8 = Series(8,"spartacus","tt1442449")
        val series9 = Series(9,"familyGuy","tt0182576")
        val series10 = Series(10,"narcos","tt2707408")
        val series11 = Series(11,"bandOfBrothers","tt0185906")
        val series12 = Series(12,"riseOfEmpiresOttoman","tt9244578")

        seriesList = ArrayList<Series>()
        seriesList.add(series1)
        seriesList.add(series2)
        seriesList.add(series3)
        seriesList.add(series4)
        seriesList.add(series5)
        seriesList.add(series6)
        seriesList.add(series7)
        seriesList.add(series8)
        seriesList.add(series9)
        seriesList.add(series10)
        seriesList.add(series11)
        seriesList.add(series12)

        adapter = SeriesActivityRvAdapter(this,seriesList)

        rv.adapter = adapter

    }
}