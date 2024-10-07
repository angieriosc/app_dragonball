package com.example.kotlin.exam_s.data.repositories

import android.util.Log
import com.example.kotlin.exam_s.data.network.DragonBallApiClient
import com.example.kotlin.exam_s.data.network.model.DragonballBase

class DragonballRepository {

    private val apiDragon = DragonBallApiClient()

    suspend fun getCharacterById(id: Int): DragonballBase? {
        return try {
            Log.d("DRAGONBALLREPO", "entro r$id")
            apiDragon.getCharacterById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
