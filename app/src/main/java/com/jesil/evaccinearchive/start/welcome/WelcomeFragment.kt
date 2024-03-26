package com.jesil.evaccinearchive.start.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.jesil.evaccinearchive.R
import com.jesil.evaccinearchive.WelcomeState
import com.jesil.evaccinearchive.databinding.FragmentWelcomeBinding
import com.jesil.evaccinearchive.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private val viewModel by viewModels<WelcomeViewModel>()
    private val binding by viewBinding(FragmentWelcomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpObservers()
    }

    private fun setUpViews() {
        binding.welcomeSignIn.setOnClickListener {
            viewModel.navigate()
        }
    }

    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.action.collectLatest {
                    when (it) {
                        is WelcomeState.Navigate -> findNavController().navigate(it.destination)
                    }
                }
            }
        }
    }

}