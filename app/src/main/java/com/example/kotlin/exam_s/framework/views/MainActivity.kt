package com.example.kotlin.exam_s.framework.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.exam_s.databinding.ActivityMainBinding
import com.example.kotlin.exam_s.framework.adapters.MainAdapter
import com.example.kotlin.exam_s.framework.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    // ViewBinding y ViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Configura el adaptador para ViewPager2, pasando la actividad actual
        val pagerAdapter = MainAdapter(this)
        binding.vFragment.adapter = pagerAdapter

        // Configura el TabLayout con ViewPager2
        TabLayoutMediator(binding.tabProfile, binding.vFragment) { tab, position ->
            tab.text = when (position) {
                0 -> "Opción 1"
                1 -> "Opción 2"
                2 -> "Opción 3"
                else -> null
            }
        }.attach()
    }
}
