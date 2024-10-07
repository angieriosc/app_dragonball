package com.example.kotlin.exam_s.framework.adapters

import android.util.Log
import com.example.kotlin.exam_s.data.network.model.DragonballBase
import com.example.kotlin.exam_s.data.repositories.DragonballRepository

class GetDragonRequirement(private val repository: DragonballRepository) {

    suspend operator fun invoke(id: Int): DragonballBase? {
        return repository.getCharacterById(id)
    }
}
