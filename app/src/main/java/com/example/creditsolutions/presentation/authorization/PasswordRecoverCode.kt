package com.example.creditsolutions.presentation.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.creditsolutions.R
import com.example.creditsolutions.databinding.FragmentPasswordRecoverCodeBinding


class PasswordRecoverCode : Fragment() {
    private var _binding: FragmentPasswordRecoverCodeBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordRecoverCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.approve.setOnClickListener {
            findNavController().navigate(R.id.action_passwordRecoverCode_to_createPassword)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}