package com.example.catalog.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.catalog.R
import com.example.catalog.databinding.FragmentDetailsFrBinding
import com.example.catalog.models.ModelClass


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailsFrBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentDetailsFrBinding.inflate(layoutInflater)

        val item = arguments?.getSerializable("KEY") as ModelClass
        Glide.with(requireContext()).load(item.image).into(binding.imageDet)
        binding.nameDet.text = item.name
        binding.descriptionL.text = item.description
        binding.detailedDescription.text = item.detailDescription



        return binding.root



}}