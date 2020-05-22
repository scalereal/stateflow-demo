package dev.shreyaspatil.stateflow.example.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {
    private val _countState = MutableStateFlow(0)

    val countState: StateFlow<Int> = _countState

    fun incrementCount() {
        _countState.value++
    }

    fun decrementCount() {
        _countState.value--
    }
}