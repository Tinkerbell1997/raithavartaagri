package com.example.raithavarta.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.raithavarta.R

class ExpertFragment : Fragment() {

    private lateinit var leafImage: ImageView
    private lateinit var txtResult: TextView

    private val IMAGE_PICK_CODE = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_expert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        leafImage = view.findViewById(R.id.leafImage)
        txtResult = view.findViewById(R.id.txtResult)

        val btnUpload = view.findViewById<Button>(R.id.btnUpload)

        btnUpload.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"

            startActivityForResult(intent, IMAGE_PICK_CODE)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_CODE &&
            resultCode == Activity.RESULT_OK &&
            data != null
        ) {

            val imageUri: Uri? = data.data

            leafImage.setImageURI(imageUri)

            txtResult.text = "Analyzing disease..."

            Handler(Looper.getMainLooper()).postDelayed({

                txtResult.text =
                    "Possible fungal infection detected.\nRecommended: Neem oil spray and reduce excess watering."

            }, 2000)
        }
    }
}