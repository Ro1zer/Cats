package com.healthcare.cats.features.cat.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healthcare.cats.features.cat.data.mapper.toCatUiState
import com.healthcare.cats.features.cat.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    private val catsList = mutableListOf<CatUiState>()
    private val _uiState = MutableStateFlow( CatUiState())

    private var currentIndex: Int = 0
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            fillCatsListByResponse()
        }
    }

    private suspend fun fillCatsListByResponse() {
        catsList.apply {
            clear()
            addAll(
                RetrofitClient.catAPIService.getBreeds().map { catDto ->
                    catDto.toCatUiState()
                }
            )
        }
        currentIndex = 0
        _uiState.apply {
            value = value.copy(
                name = catsList.first().name,
                description = catsList.first().description,
                imageUrl = catsList.first().imageUrl
            )
        }
    }

    fun nextCat() {
        catsList.getOrNull(currentIndex + 1)?.let { next ->
            currentIndex++
            _uiState.value = _uiState.value.copy(
                name = next.name,
                description = next.description,
                imageUrl = next.imageUrl
            )
        }
    }

    fun previousCat() {
        catsList.getOrNull(currentIndex - 1)?.let { previous ->
            currentIndex--
            _uiState.value = _uiState.value.copy(
                name = previous.name,
                description = previous.description,
                imageUrl = previous.imageUrl
            )
        }
    }
}
