package com.kotlin.sacalabici.framework.adapters.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.exam_s.R
import com.example.kotlin.exam_s.databinding.FragmentOpcion1Binding
import com.example.kotlin.exam_s.framework.adapters.CharactersAdapter
import com.example.kotlin.exam_s.framework.viewmodel.MainViewModel

class opcion3Fragment : Fragment() {

    private var _binding: FragmentOpcion1Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel // Declarar el ViewModel
    private lateinit var adapter: CharactersAdapter // Declarar el Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout utilizando DataBinding
        _binding = FragmentOpcion1Binding.inflate(inflater, container, false)

        // Inicializar el RecyclerView y el Adapter
        setupRecyclerView()

        // Obtener el ViewModel utilizando ViewModelProvider solo una vez
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.fetchAllCharacters()

        // Observar los cambios en LiveData y actualizar el RecyclerView
        viewModel.charactersLiveData.observe(viewLifecycleOwner) { characters ->
            characters?.let {
                // Filtrar solo los personajes femeninos
                val worldCharacters = it.filter { character -> character.originPlanet.name == "Tierra" }
                // Actualizar el adaptador con la lista de personajes femeninos
                adapter.updateCharacters(worldCharacters)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evitar pérdidas de memoria
    }

    // Configurar el RecyclerView y su adaptador
    private fun setupRecyclerView() {
        // Inicializar el RecyclerView con un LinearLayoutManager
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Inicializar el adaptador con una lista vacía inicialmente
        adapter = CharactersAdapter(emptyList(), requireContext())

        // Conectar el adaptador al RecyclerView
        binding.recyclerView.adapter = adapter
    }
}