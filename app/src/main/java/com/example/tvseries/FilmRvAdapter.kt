package com.example.tvseries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class FilmRvAdapter(private val mContext: Context, private val filmList:List<Films>) : RecyclerView.Adapter<FilmRvAdapter.CardViewDesignObjectHolder>() {

    inner class CardViewDesignObjectHolder(view: View): RecyclerView.ViewHolder(view) {
        var filmCardView: CardView
        var cardImage: ImageView
        init {
            filmCardView = view.findViewById(R.id.filmCardView)
            cardImage = view.findViewById(R.id.card_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectHolder {

        val design = LayoutInflater.from(mContext).inflate(R.layout.film_cardview,parent,false)
        return  CardViewDesignObjectHolder(design)
    }

    override fun onBindViewHolder(holder: CardViewDesignObjectHolder, position: Int) {
        val film = filmList[position]
        if (film.filmNo==1) {
            holder.cardImage.setBackgroundResource(R.drawable.breakingbad)

        }
        else if (film.filmNo==2) {
            holder.cardImage.setBackgroundResource(R.drawable.vikings)

        }
        if (film.filmNo==3) {
            holder.cardImage.setBackgroundResource(R.drawable.got)

        }
        if (film.filmNo==4) {
            holder.cardImage.setBackgroundResource(R.drawable.breakingbad)

        }
        if (film.filmNo==5) {
            holder.cardImage.setBackgroundResource(R.drawable.vikings)

        }
        if (film.filmNo==6) {
            holder.cardImage.setBackgroundResource(R.drawable.got)

        }


    }

    override fun getItemCount(): Int {
        return filmList.size
    }


}