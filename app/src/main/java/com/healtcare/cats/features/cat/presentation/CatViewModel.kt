package com.healtcare.cats.features.cat.presentation

import androidx.lifecycle.ViewModel
import com.healtcare.cats.features.cat.data.catUiStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//TODO: Implement business logic here
class CatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CatUiState())
    private var currentIndex: Int = 0
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = catUiStates[currentIndex]
    }

    fun nextCat() {
        val nextCat = catUiStates.getOrNull(currentIndex.inc())
        if (nextCat != null) {
            currentIndex++
            _uiState.update {
                nextCat
            }
        }

    }

    fun previousCat() {
        val previousCat = catUiStates.getOrNull(currentIndex.dec())
        if (previousCat != null) {
            currentIndex--
            _uiState.update {
                previousCat
            }
        }
    }
}