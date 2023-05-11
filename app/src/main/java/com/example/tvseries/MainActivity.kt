package com.example.tvseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    private lateinit var filmList : ArrayList<Films>
    private lateinit var adapter: FilmRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv_film)

        rv.setHasFixedSize(true)

        rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val i1 = Films(1)
        val i2 = Films(2)
        val i3 = Films(3)
        val i4 = Films(4)
        val i5 = Films(5)
        val i6 = Films(6)


        filmList = ArrayList<Films>()
        filmList.add(i1)
        filmList.add(i2)
        filmList.add(i3)
        filmList.add(i4)
        filmList.add(i5)
        filmList.add(i6)

        adapter = FilmRvAdapter(this,filmList)

        rv.adapter = adapter
    }
}