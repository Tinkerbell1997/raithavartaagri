package com.example.raithavarta.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.raithavarta.model.TipEntity

@Dao
interface TipDao {

    @Insert
    suspend fun insertTip(tip: TipEntity)

    @Query("SELECT * FROM tips")
    suspend fun getAllTips(): List<TipEntity>

    @Delete
    suspend fun deleteTip(tip: TipEntity)
}