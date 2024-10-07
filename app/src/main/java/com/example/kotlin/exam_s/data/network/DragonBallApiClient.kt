package com.example.kotlin.exam_s.data.network

import android.util.Log
import com.example.kotlin.exam_s.data.network.model.DragonballBase

class DragonBallApiClient {
    private val api: DragonballAPIService = DragonballNetworkModuleDI.createApiService()

    suspend fun getCharacterById(id: Int): DragonballBase? {
        Log.d("DRAGONBALLApi", "entro api$id")
        return try {
            // Llamada al API para obtener el personaje
            api.getCharacterById(id)

        } catch (e: Exception) {
            e.printStackTrace()
            // Manejo de error
            null
        }
    }
}
