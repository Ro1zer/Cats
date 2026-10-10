package com.healthcare.cats.features.cat.data.remote

import com.healthcare.cats.features.cat.data.remote.dto.CatDto
import retrofit2.http.GET

interface CatAPIService {
    @GET("breeds")
    suspend fun getBreeds(): List<CatDto>
}