package com.example.raithavarta.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.raithavarta.R
import com.example.raithavarta.adapter.TipAdapter
import com.example.raithavarta.database.DatabaseInstance
import com.example.raithavarta.LocaleHelper
import com.example.raithavarta.model.TipEntity
import com.example.raithavarta.model.TipModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnTranslate: Button
    private var isKannada = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        btnTranslate = view.findViewById(R.id.btnTranslate)

        val db = DatabaseInstance.getDatabase(requireContext())
        val dao = db.tipDao()

        lifecycleScope.launch {

            // Insert default data only once
            withContext(Dispatchers.IO) {

                if (dao.getAllTips().isEmpty()) {

                    dao.insertTip(
                        TipEntity(0, R.string.paddy_title, R.string.paddy_desc, R.drawable.paddy)
                    )
                    dao.insertTip(
                        TipEntity(0, R.string.tomato_title, R.string.tomato_desc, R.drawable.tomato)
                    )
                    dao.insertTip(
                        TipEntity(0, R.string.coconut_title, R.string.coconut_desc, R.drawable.coconut)
                    )
                    dao.insertTip(
                        TipEntity(0, R.string.areca_title, R.string.areca_desc, R.drawable.areca)
                    )
                }
            }

            // Load data
            val data = withContext(Dispatchers.IO) {
                dao.getAllTips()
            }

            // Convert DB → UI (IMPORTANT FIX HERE)
            val tips = data.map {
                TipModel(
                    getString(it.cropTitleRes),
                    getString(it.cropDescRes),
                    it.imageResId
                )
            }

            viewPager.adapter = TipAdapter(tips)
        }

        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3

        // Language Toggle
        btnTranslate.setOnClickListener {

            isKannada = !isKannada

            if (isKannada) {
                LocaleHelper.setLocale(requireActivity(), "kn")
            } else {
                LocaleHelper.setLocale(requireActivity(), "en")
            }

            requireActivity().recreate()
        }
    }
}
