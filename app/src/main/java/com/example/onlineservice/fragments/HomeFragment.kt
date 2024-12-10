package com.example.onlineservice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.onlineservice.databinding.FragmentHomeBinding
import com.example.onlineservice.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    // Gunakan backing property untuk binding agar aman
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi ViewModel
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inisialisasi binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        // Observasi LiveData dari ViewModel
        homeViewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textHome.text = text
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hapus binding untuk mencegah memory leak
        _binding = null
    }
}
