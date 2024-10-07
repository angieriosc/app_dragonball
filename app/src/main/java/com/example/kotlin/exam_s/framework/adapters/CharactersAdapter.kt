package com.example.kotlin.exam_s.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.exam_s.data.network.model.DragonballBase
import com.example.kotlin.exam_s.databinding.ItemCharacterBinding
import com.example.kotlin.exam_s.framework.adapters.viewholders.MainViewHolder

class CharactersAdapter(
    private var characters: List<DragonballBase>,  // Declarar la lista como una propiedad mutable
    private val context: Context
) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(characters[position], context) // Vincular el personaje en la posición dada
    }

    override fun getItemCount(): Int {
        return characters.size // Devolver el tamaño real de la lista de personajes
    }

    // Método para actualizar la lista de personajes
    fun updateCharacters(newCharacters: List<DragonballBase>) {
        characters = newCharacters // Actualizar la lista de personajes
        notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }
}
