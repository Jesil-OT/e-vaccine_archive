package com.jesil.evaccinearchive.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.jesil.evaccinearchive.HomeState
import com.jesil.evaccinearchive.R
import com.jesil.evaccinearchive.databinding.FragmentLoginBinding
import com.jesil.evaccinearchive.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModels<LoginViewModel>()
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpViews()
    }

    private fun setUpViews() {
        binding.loginWithGoogle.setOnClickListener { viewModel.navigate() }
    }

    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.action.collectLatest {
                    when (it) {
                        is HomeState.Navigate -> findNavController().navigate(it.destination)
                    }
                }
            }
        }
    }
}