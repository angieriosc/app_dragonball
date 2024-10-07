package com.example.kotlin.exam_s.data.network

import com.example.kotlin.exam_s.data.network.model.DragonballBase
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonballAPIService {
    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): DragonballBase?

}
