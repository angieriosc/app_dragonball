package com.example.kotlin.exam_s.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.exam_s.data.network.model.DragonballBase
import com.example.kotlin.exam_s.data.repositories.DragonballRepository
import com.example.kotlin.exam_s.framework.adapters.GetDragonRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = DragonballRepository()
    private val getDragonRequirement = GetDragonRequirement(repository)

    // LiveData para observar el personaje
    val charactersLiveData: MutableLiveData<List<DragonballBase>> = MutableLiveData()

    private val characterList = mutableListOf<DragonballBase>()

    fun fetchAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Itera de 1 a 58 para obtener todos los personajes
                for (i in 1..58) {
                    val result: DragonballBase? = getDragonRequirement(i) // Usar el ID
                    result?.let {
                        characterList.add(it)
                    }
                }
                // Publicar la lista completa cuando se hayan obtenido todos los personajes
                charactersLiveData.postValue(characterList)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching characters: ${e.message}")
            }
        }
    }

    private fun postErrorDragon(errorMessage: String) {
        // Aquí puedes implementar la lógica para manejar el error
        Log.e("MainViewModel", errorMessage)
        // Puedes usar LiveData para publicar el error si es necesario
    }
}
