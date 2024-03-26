package com.jesil.evaccinearchive

import androidx.navigation.NavDirections

sealed interface WelcomeState {
    data class Navigate(val destination : NavDirections) : WelcomeState
}

sealed interface HomeState{
    data class Navigate(val destination: NavDirections) : HomeState
}