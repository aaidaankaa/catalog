package com.example.catalog.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catalog.Constants
import com.example.catalog.R
import com.example.catalog.adapters.GridAdapter
import com.example.catalog.databinding.FragmentGridBinding

class GridFragment : Fragment() {
    private var _binding: FragmentGridBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGridBinding.inflate(inflater, container, false)

        binding.recyclerviewGrid.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.recyclerviewGrid.adapter = GridAdapter(Constants.array, requireActivity())

        return binding.root
    }
}