package com.healthcare.cats.features.cat.data.mapper

import com.healthcare.cats.features.cat.data.remote.dto.CatDto
import com.healthcare.cats.features.cat.presentation.CatUiState

fun CatDto.toCatUiState(): CatUiState {
    return CatUiState(
        name = this.name ?: "NONE",
        description = this.description ?: "NONE",
        imageUrl = this.image?.url ?: "NONE"
    )
}