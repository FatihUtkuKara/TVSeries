package com.example.tvseries

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tvseries.model.SeriesInfo
import com.example.tvseries.retrofit.ApiUtils
import com.example.tvseries.retrofit.SeriesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var seriesInfo : SeriesInfo
    private var seriesDıf: SeriesDaoInterface? = null
    private lateinit var rv : RecyclerView
    private lateinit var filmList : ArrayList<Series>
    private lateinit var seriesAdapter: SeriesRvAdapter
    private lateinit var seriesButton : ImageButton
    private lateinit var search : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search = findViewById(R.id.search)
        seriesDıf = ApiUtils.getSeriesDaoInterface()
        seriesButton = findViewById(R.id.seriesButton)
        rv = findViewById(R.id.rv_film)

        rv.setHasFixedSize(true)

        rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val i1 = Series(1)
        val i2 = Series(2)
        val i3 = Series(3)
        val i4 = Series(4)
        val i5 = Series(5)
        val i6 = Series(6)


        filmList = ArrayList<Series>()
        filmList.add(i1)
        filmList.add(i2)
        filmList.add(i3)
        filmList.add(i4)
        filmList.add(i5)
        filmList.add(i6)
        //getSeries()
        seriesAdapter = SeriesRvAdapter(this,filmList)

        rv.adapter = seriesAdapter

        seriesButton.setOnClickListener { view ->
            onSeriesButtonClick(view)
        }
        search.setOnClickListener{
            val searchQuery = search.text.toString()
            val filteredFilmList = filterSeriesBySearchQuery(filmList,searchQuery)
            seriesAdapter.updateData(filteredFilmList)
        }

    }
    private fun onSeriesButtonClick(view: View) {

        Log.d("SeriesButton", "Series button clicked!")

        val intent = Intent(this, SeriesActivity::class.java)
        startActivity(intent)
    }

    fun filterSeriesBySearchQuery(movieList: List<Series>, searchQuery: String): List<Series> {
        val filteredList = mutableListOf<Series>()
        for (series in filmList) {
            if (series.name.contains(searchQuery, ignoreCase = true)) {
                filteredList.add(movie)
                //TODO Burada movie nesnesi oluşturulmuş seriese çevrilecek ve series sınıfı değiştirilecek series name alacak.
            }
        }
        return filteredList
    }

    fun SeriesRvAdapter.updateData(newMovieList: List<Series>) {
        movieList.clear()
        movieList.addAll(newMovieList)
        notifyDataSetChanged()
    }

    fun getSeries() {

        val idsMap = mutableMapOf<String, String>()
        idsMap["i"] = "tt7366338"
        idsMap["rapidapi-key"] = "937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574"

        //val call = getSeries(idsMap)

        var id: String
        id = "tt7366338,tt1475582,tt5753856,tt0944947,tt0460649,tt1442437," +
                "tt10048342"

        seriesDıf!!.getSeries(idsMap)!!.enqueue(object : Callback<SeriesInfo?> {

            override fun onResponse(call: Call<SeriesInfo?>, response: Response<SeriesInfo?>) {
                val series: SeriesInfo? = response.body()
                val i7 = Series(series!!.keywords[0]!!.id!!.toInt())

             filmList.add(i7)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<SeriesInfo?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}




