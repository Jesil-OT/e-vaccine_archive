package com.jesil.evaccinearchive.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.evaccinearchive.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _action = MutableSharedFlow<HomeState>()
    val action = _action.asSharedFlow()

    fun navigate() = viewModelScope.launch{
        _action.emit(HomeState.Navigate(LoginFragmentDirections.toHomeFragment()))
    }
}