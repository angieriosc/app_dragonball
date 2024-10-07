package com.example.kotlin.exam_s.data.network.model

import com.google.gson.annotations.SerializedName

data class DragonballBase(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ki") val ki: String,
    @SerializedName("maxKi") val maxKi: String,
    @SerializedName("race") val race: String?,
    @SerializedName("gender") val gender: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("affiliation") val affiliation: String?,

    // Datos adicionales para originPlanet y transformations
    @SerializedName("originPlanet") val originPlanet: OriginPlanet,
    @SerializedName("transformations") val transformations: List<Transformation>
)

// Clase para manejar el planeta de origen
data class OriginPlanet(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("isDestroyed") val isDestroyed: Boolean,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("deletedAt") val deletedAt: String?
)

// Clase para manejar las transformaciones
data class Transformation(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("powerLevel") val powerLevel: String,
    @SerializedName("description") val description: String
)
