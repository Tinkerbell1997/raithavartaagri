package com.example.raithavarta.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips")
data class TipEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // store string resource IDs instead of text
    val cropTitleRes: Int,

    val cropDescRes: Int,

    val imageResId: Int
)