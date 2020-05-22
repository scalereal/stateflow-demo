package dev.shreyaspatil.stateflow.example.ui.main

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun test_check_initial_value() {
        assertEquals(mainViewModel.countState.value, 0)
    }

    @Test
    fun test_check_increment_value() {
        mainViewModel.incrementCount()
        assertEquals(mainViewModel.countState.value, 1)
    }

    @Test
    fun test_check_decrement_value() {
        mainViewModel.decrementCount()
        assertEquals(mainViewModel.countState.value, -1)
    }
}
