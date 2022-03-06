package com.example.catalog.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalog.Constants
import com.example.catalog.R
import com.example.catalog.adapters.LinearAdapter
import com.example.catalog.databinding.FragmentLinearBinding


class LinearFragment : Fragment() {
    private var _binding: FragmentLinearBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLinearBinding.inflate(inflater, container, false)

        binding.recyclerviewLinear.adapter = LinearAdapter(Constants.array, requireActivity())

        return binding.root}
}