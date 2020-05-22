package dev.shreyaspatil.stateflow.example.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dev.shreyaspatil.stateflow.example.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountObserver()
        initView()
    }

    private fun initCountObserver() {
        lifecycleScope.launch {
            viewModel.countState.collect { value ->
                textview_count.text = "$value"
            }
        }
    }

    private fun initView() {
        button_plus.setOnClickListener(::incrementCounter)
        button_minus.setOnClickListener(::decrementCounter)
    }

    private fun incrementCounter(view: View) {
        viewModel.incrementCount()
    }

    private fun decrementCounter(view: View) {
        viewModel.decrementCount()
    }
}
