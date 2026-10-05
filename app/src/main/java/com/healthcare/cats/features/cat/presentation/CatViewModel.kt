package com.healthcare.cats.features.cat.presentation

import androidx.lifecycle.ViewModel
import com.healthcare.cats.features.cat.data.catUiStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(catUiStates.firstOrNull() ?: CatUiState())
    private var currentIndex: Int = 0
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()

    fun nextCat() {
        catUiStates.getOrNull(currentIndex + 1)?.let { next ->
            currentIndex++
            _uiState.value = next
        }
    }

    fun previousCat() {
        catUiStates.getOrNull(currentIndex - 1)?.let { previous ->
            currentIndex--
            _uiState.value = previous
        }
    }
}