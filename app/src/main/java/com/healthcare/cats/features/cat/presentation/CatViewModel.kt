package com.healthcare.cats.features.cat.presentation

import androidx.lifecycle.ViewModel
import com.healthcare.cats.features.cat.data.catModels
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CatUiState(currentCat = catModels.firstOrNull()))
    private var currentIndex: Int = 0
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()

    fun nextCat() {
        catModels.getOrNull(currentIndex + 1)?.let { next ->
            currentIndex++
            _uiState.value = _uiState.value.copy(currentCat = next)
        }
    }

    fun previousCat() {
        catModels.getOrNull(currentIndex - 1)?.let { previous ->
            currentIndex--
            _uiState.value = _uiState.value.copy(currentCat = previous)
        }
    }
}
