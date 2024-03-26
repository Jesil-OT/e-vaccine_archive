package com.jesil.evaccinearchive.start.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.evaccinearchive.WelcomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {

    private val _action = MutableSharedFlow<WelcomeState>()

    val action = _action.asSharedFlow()
    fun navigate() = viewModelScope.launch{
       _action.emit(WelcomeState.Navigate(WelcomeFragmentDirections.toLoginFragment()))
    }

}