# StateFlow - Demo

## What is `StateFlow`?
- It is a *flow* which emits updates to its collectors.
- Value can be observed by collecting values from the flow.

## Implementation
### `ViewModel.kt`:

```kt
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
```

### `MainActivity.kt`:
```kt
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

```

## Reference
- [StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/index.html)
