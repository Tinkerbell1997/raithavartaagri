package com.example.raithavarta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.raithavarta.R
import com.example.raithavarta.adapter.SuccessStoryAdapter
import com.example.raithavarta.model.SuccessStory

class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storyPager = view.findViewById<ViewPager2>(R.id.storyViewPager)

        val stories = listOf(

            SuccessStory(
                "Ramesh Gowda",
                "Mandya, Karnataka",
                "Paddy",
                "Used drip irrigation and neem spray method.",
                "Yield increased by 20%",
                R.drawable.farmer1
            ),

            SuccessStory(
                "Shiva Kumar",
                "Tumkur, Karnataka",
                "Coconut",
                "Applied organic compost regularly.",
                "Better crop quality and higher market price",
                R.drawable.farmer2
            )
        )

        storyPager.adapter = SuccessStoryAdapter(stories)
    }
}