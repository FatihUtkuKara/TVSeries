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

        rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)

        val i1 = Series(1)
        val i2 = Series(2)
        val i3 = Series(3)
        val i4 = Series(4)
        val i5 = Series(5)
        val i6 = Series(6)

        seriesList = ArrayList<Series>()
        seriesList.add(i1)
        seriesList.add(i2)
        seriesList.add(i3)
        seriesList.add(i4)
        seriesList.add(i5)
        seriesList.add(i6)

        adapter = SeriesActivityRvAdapter(this,seriesList)

        rv.adapter = adapter

    }
}