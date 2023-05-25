package com.example.tvseries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class SeriesRvAdapter(private val mContext: Context, private val seriesList: List<Series>) : RecyclerView.Adapter<SeriesRvAdapter.CardViewDesignObjectHolder>() {

    inner class CardViewDesignObjectHolder(view: View): RecyclerView.ViewHolder(view) {
        var seriesCardView: CardView
        var cardImage: ImageView
        init {
            seriesCardView = view.findViewById(R.id.filmCardView)
            cardImage = view.findViewById(R.id.card_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectHolder {

        val design = LayoutInflater.from(mContext).inflate(R.layout.film_cardview,parent,false)
        return  CardViewDesignObjectHolder(design)
    }

    override fun onBindViewHolder(holder: CardViewDesignObjectHolder, position: Int) {
        val series = seriesList[position]
        if (series.seriesNo==1) {
            holder.cardImage.setBackgroundResource(R.drawable.peaky)

        }
        else if (series.seriesNo==2) {
            holder.cardImage.setBackgroundResource(R.drawable.office)

        }
        if (series.seriesNo==3) {
            holder.cardImage.setBackgroundResource(R.drawable.himym)

        }
        if (series.seriesNo==4) {
            holder.cardImage.setBackgroundResource(R.drawable.breakingbad)

        }
        if (series.seriesNo==5) {
            holder.cardImage.setBackgroundResource(R.drawable.got)

        }
        if (series.seriesNo==6) {
            holder.cardImage.setBackgroundResource(R.drawable.vikings)
        }
        if (series.seriesNo==7) {
            holder.cardImage.setBackgroundResource(R.drawable.afterlife)
        }
        if (series.seriesNo==8) {
            holder.cardImage.setBackgroundResource(R.drawable.spartacus)
        }
        if (series.seriesNo==9) {
            holder.cardImage.setBackgroundResource(R.drawable.familyguy)
        }
        if (series.seriesNo==10) {
            holder.cardImage.setBackgroundResource(R.drawable.narcos)
        }
        if (series.seriesNo==11) {
            holder.cardImage.setBackgroundResource(R.drawable.bandofbrothers)
        }
        if (series.seriesNo==12) {
            holder.cardImage.setBackgroundResource(R.drawable.ottoman)
        }
        holder.seriesCardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("seriesCode",series.code)
            mContext.startActivity(intent)
        })


    }

    override fun getItemCount(): Int {
        return seriesList.size
    }


}