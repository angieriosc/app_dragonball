package com.example.kotlin.exam_s.data.network

import android.util.Log
import com.example.kotlin.exam_s.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DragonballNetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    fun createApiService(): DragonballAPIService {
        Log.d("DRAGONBALL", "entro NETW")
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(DragonballAPIService::class.java)
    }

}
