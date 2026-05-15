package com.example.raithavarta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.raithavarta.R
import com.example.raithavarta.weather.RetrofitClient
import com.example.raithavarta.weather.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherFragment : Fragment() {

    private val apiKey = "87a2ad7ea2dae4498748d1e45fb168e7"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        val cityInput = view.findViewById<EditText>(R.id.cityInput)
        val searchBtn = view.findViewById<Button>(R.id.searchBtn)

        val tempText = view.findViewById<TextView>(R.id.tempText)
        val descText = view.findViewById<TextView>(R.id.descText)
        val locationText = view.findViewById<TextView>(R.id.locationText)

        searchBtn.setOnClickListener {

            val city = cityInput.text.toString()

            if (city.isNotEmpty()) {

                RetrofitClient.api.getWeather(city, apiKey)
                    .enqueue(object : Callback<WeatherResponse> {

                        override fun onResponse(
                            call: Call<WeatherResponse>,
                            response: Response<WeatherResponse>
                        ) {

                            if (response.isSuccessful && response.body() != null) {

                                val data = response.body()!!

                                tempText.text = "${data.main.temp}°C"
                                descText.text = data.weather[0].description
                                locationText.text = city

                            } else {
                                tempText.text = "Error"
                                descText.text = "No data"
                            }
                        }

                        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                            tempText.text = "Failed"
                            descText.text = "Check Internet"
                        }
                    })
            } else {
                cityInput.error = "Enter city"
            }
        }

        return view
    }
}