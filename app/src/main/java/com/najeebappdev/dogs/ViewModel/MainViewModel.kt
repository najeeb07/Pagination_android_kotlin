package com.najeebappdev.dogs.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.najeebappdev.dogs.Data.Dogs
import com.najeebappdev.dogs.Network.Apiservice
import com.najeebappdev.dogs.Repository.DogsPagingSource

import kotlinx.coroutines.flow.Flow


class MainViewModel(private val apiService: Apiservice) : ViewModel() {
    val getAllDogs: Flow<PagingData<Dogs>> = Pager(config = PagingConfig(10, enablePlaceholders = false)) {
        DogsPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}