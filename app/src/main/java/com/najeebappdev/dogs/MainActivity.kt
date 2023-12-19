package com.najeebappdev.dogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.najeebappdev.dogs.Adapter.DogsAdapter
import com.najeebappdev.dogs.Adapter.LoaderStateAdapter
import com.najeebappdev.dogs.Network.ApiClient
import com.najeebappdev.dogs.ViewModel.MainViewModel
import com.najeebappdev.dogs.databinding.ActivityMainBinding

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var dogsAdapter: DogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel = MainViewModel(ApiClient.apiService)
        dogsAdapter = DogsAdapter()

        initRecyclerview()

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.getAllDogs.collectLatest { response ->
                    binding.apply {
                        progressBar.isVisible = false
                        recyclerview.isVisible = true
                    }
                    dogsAdapter.submitData(response)
                }
            }
        }
    }

    private fun initRecyclerview() {
        binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)

                adapter = dogsAdapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapter { dogsAdapter.retry() },
                    footer = LoaderStateAdapter { dogsAdapter.retry() }
                )
            }
        }
    }
}

