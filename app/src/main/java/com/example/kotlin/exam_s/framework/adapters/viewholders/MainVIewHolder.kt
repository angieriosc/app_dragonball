package com.example.kotlin.exam_s.framework.adapters.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.exam_s.data.network.model.DragonballBase
import com.example.kotlin.exam_s.databinding.ItemCharacterBinding


class MainViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DragonballBase, context: Context) {
        // Usar binding para establecer el nombre del personaje
        Log.d("name","name${item.name}")
        binding.characterName.text = item.name
        binding.characterKi.text=item.ki
        binding.charactermaxKi.text = item.maxKi
        binding.originPlanetName.text = item.originPlanet.name
        binding.characterRace.text = item.race
        binding.characterGender.text = item.gender

        // Cargar la imagen del personaje usando Glide
        loadCharacterImage(item.image, binding.characterImage, context)
        loadCharacterImage(item.originPlanet.image, binding.originPlanetImage, context)

        // Configura un listener para manejar clics en el elemento
        binding.root.setOnClickListener {
            // Manejar clics aquí si es necesario
        }
    }

    // Método privado para cargar la imagen del personaje
    private fun loadCharacterImage(imageUrl: String, imageView: ImageView, context: Context) {
        // Usar Glide para cargar la imagen de manera eficiente
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)

        Glide.with(context)
            .load(imageUrl)
            .apply(requestOptions)
            .into(imageView)
    }
}
