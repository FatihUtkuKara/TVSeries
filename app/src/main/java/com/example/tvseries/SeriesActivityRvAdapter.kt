package com.example.tvseries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SeriesActivityRvAdapter (private val mContext: Context, private val seriesList: List<Series>) : RecyclerView.Adapter<SeriesActivityRvAdapter.CardViewDesignObjectHolder>() {

    inner class CardViewDesignObjectHolder(view: View): RecyclerView.ViewHolder(view) {
        var seriesCardView: CardView
        var cardImage: ImageView
        init {
            seriesCardView = view.findViewById(R.id.seriesCardView)
            cardImage = view.findViewById(R.id.series_card_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectHolder {

        val design = LayoutInflater.from(mContext).inflate(R.layout.series_cardview,parent,false)
        return  CardViewDesignObjectHolder(design)
    }



    override fun getItemCount(): Int {
        return seriesList.size
    }

    override fun onBindViewHolder(
        holder: SeriesActivityRvAdapter.CardViewDesignObjectHolder,
        position: Int
    ) {
        val series = seriesList[position]
        if (series.seriesNo==1) {
            holder.cardImage.setBackgroundResource(R.drawable.breakingbad)

        }
        else if (series.seriesNo==2) {
            holder.cardImage.setBackgroundResource(R.drawable.vikings)

        }
        if (series.seriesNo==3) {
            holder.cardImage.setBackgroundResource(R.drawable.got)

        }
        if (series.seriesNo==4) {
            holder.cardImage.setBackgroundResource(R.drawable.breakingbad)

        }
        if (series.seriesNo==5) {
            holder.cardImage.setBackgroundResource(R.drawable.vikings)

        }
        if (series.seriesNo==6) {
            holder.cardImage.setBackgroundResource(R.drawable.got)
        }
        holder.seriesCardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            mContext.startActivity(intent)
        })
    }
}