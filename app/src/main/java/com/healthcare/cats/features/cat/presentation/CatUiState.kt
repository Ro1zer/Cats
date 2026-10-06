package com.healthcare.cats.features.cat.presentation

import com.healthcare.cats.features.cat.domain.model.CatModel

//TODO: Think about adding some additional fields
data class CatUiState(
    val currentCat: CatModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)