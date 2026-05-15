package com.example.raithavarta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.raithavarta.R
import com.example.raithavarta.model.TipModel

class TipAdapter(
    private val tips: List<TipModel>
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.tipImage)
        val crop: TextView = view.findViewById(R.id.tipCrop)
        val desc: TextView = view.findViewById(R.id.tipDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)

        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {

        val tip = tips[position]

        holder.crop.text = tip.crop
        holder.desc.text = tip.description

        Glide.with(holder.image.context)
            .load(tip.imageResId)
            .centerCrop()
             // optional (safe UI)
            .into(holder.image)
    }

    override fun getItemCount(): Int = tips.size
}