package com.example.raithavarta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.raithavarta.R
import com.example.raithavarta.model.SuccessStory

class SuccessStoryAdapter(
    private val stories: List<SuccessStory>
) : RecyclerView.Adapter<SuccessStoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.storyImage)
        val name: TextView = view.findViewById(R.id.farmerName)
        val location: TextView = view.findViewById(R.id.location)
        val story: TextView = view.findViewById(R.id.story)
        val result: TextView = view.findViewById(R.id.result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_success_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val item = stories[position]

        holder.name.text = item.farmerName
        holder.location.text = item.location
        holder.story.text = item.story
        holder.result.text = item.result

        Glide.with(holder.itemView.context)
            .load(item.imageResId)
            .centerCrop()
            .into(holder.image)
    }

    override fun getItemCount(): Int = stories.size
}