package com.example.creditsolutions.presentation.authorization.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.creditsolutions.R
import com.example.creditsolutions.databinding.FragmentLoginBinding
import com.example.creditsolutions.domain.models.UserLoginModel
import com.example.creditsolutions.domain.models.authmodels.LoginRequestModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.log

@AndroidEntryPoint
class Login : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signUp)
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_passwordRecover)
        }


        binding.enter.setOnClickListener {
            viewLifecycleOwner.lifecycleScope
                .launch {
                    val email = binding.emailText.text.toString()
                    val password = binding.passwordText.text.toString()
                    viewModel.onEnterButtonClick(LoginRequestModel(email, password))
                    viewModel.state.collect{loginState ->
                        when(loginState){
                            is LoginState.InitialState -> {

                            }
                            is LoginState.Loading -> {

                            }
                            is LoginState.Error ->{
                                val data = loginState.message

                                Snackbar.make(requireView(),data,Snackbar.LENGTH_SHORT)
                                    .show()

                            }
                            is LoginState.Success ->{

                            }
                        }
                    }

                }


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}