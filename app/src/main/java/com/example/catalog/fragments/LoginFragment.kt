package com.example.catalog.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalog.R
import com.example.catalog.databinding.FragmentLoginBinding
import android.content.Context
import android.content.Intent

import com.example.catalog.HomeActivity



class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View? {
        val sharedPref = context?.let { com.example.catalog.services.SharedPreferences (it) }
        if(!sharedPref?.login.isNullOrBlank() && !sharedPref?.password.isNullOrBlank()){
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btn.setOnClickListener {
            sharedPref?.login = binding.loginEt.text.toString()
            sharedPref?.password = binding.passwordEt.text.toString()
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
        }

        binding.getBtn.setOnClickListener {
            val arg = requireActivity().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)?.apply {
                val login = getString("login", null)
                val password = getString("password", null)

                binding.loginEt.setText(login)
                binding.passwordEt.setText(password)
            }



        }

        return binding.root
    }

}
