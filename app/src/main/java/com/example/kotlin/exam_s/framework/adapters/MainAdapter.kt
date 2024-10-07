package com.example.kotlin.exam_s.framework.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kotlin.sacalabici.framework.adapters.views.fragments.opcion1Fragment
import com.kotlin.sacalabici.framework.adapters.views.fragments.opcion2Fragment
import com.kotlin.sacalabici.framework.adapters.views.fragments.opcion3Fragment

class MainAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        // Define el número de páginas/fragments que quieres mostrar
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        // Regresa el fragmento correcto para cada página
        return when (position) {
            0 -> opcion1Fragment()
            1 -> opcion2Fragment()
            2 -> opcion3Fragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
