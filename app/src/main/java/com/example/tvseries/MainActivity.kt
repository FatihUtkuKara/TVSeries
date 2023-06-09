package com.example.tvseries

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
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
    private lateinit var rv : RecyclerView
    private lateinit var filmList : ArrayList<Series>
    private lateinit var seriesAdapter: SeriesRvAdapter
    private lateinit var seriesButton : ImageButton
    private lateinit var search : EditText
    private lateinit var first : ImageView
    private lateinit var second : ImageView
    private lateinit var third : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search = findViewById(R.id.search)
        first = findViewById(R.id.firstImage)
        second = findViewById(R.id.secondImage)
        third = findViewById(R.id.thirdImage)
        seriesButton = findViewById(R.id.seriesButton)
        rv = findViewById(R.id.rv_film)

        rv.setHasFixedSize(true)

        rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

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


        filmList = ArrayList<Series>()
        filmList.add(series1)
        filmList.add(series2)
        filmList.add(series3)
        filmList.add(series4)
        filmList.add(series5)
        filmList.add(series6)
        filmList.add(series7)
        filmList.add(series8)
        filmList.add(series9)
        filmList.add(series10)
        filmList.add(series11)
        filmList.add(series12)

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

        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val searchQuery = search.text.toString()
                if (searchQuery.isEmpty()) {
                    filmList.add(series1)
                    filmList.add(series2)
                    filmList.add(series3)
                    filmList.add(series4)
                    filmList.add(series5)
                    filmList.add(series6)
                    filmList.add(series7)
                    filmList.add(series8)
                    filmList.add(series9)
                    filmList.add(series10)
                    filmList.add(series11)
                    filmList.add(series12)
                }
                    else {
                        val filteredFilmList = filterSeriesBySearchQuery(filmList, searchQuery)
                        seriesAdapter.updateData(filteredFilmList)
                    }

            }
        })

        first.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("seriesCode","tt2306299")
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up)
        }

        second.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("seriesCode","tt2442560")
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up)
        }

        third.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("seriesCode","tt0944947")
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up)
        }
    }


    private fun onSeriesButtonClick(view: View) {

        Log.d("SeriesButton", "Series button clicked!")

        val intent = Intent(this, SeriesActivity::class.java)
        startActivity(intent)
    }

    fun filterSeriesBySearchQuery(filmList: List<Series>, searchQuery: String): List<Series> {
        val filteredList = mutableListOf<Series>()
        for (series in filmList) {
            if (series.name.contains(searchQuery, ignoreCase = true)) {
                filteredList.add(series)

            }
        }
        return filteredList
    }

    fun SeriesRvAdapter.updateData(newMovieList: List<Series>) {
        filmList.clear()
        filmList.addAll(newMovieList)
        notifyDataSetChanged()
    }

}





