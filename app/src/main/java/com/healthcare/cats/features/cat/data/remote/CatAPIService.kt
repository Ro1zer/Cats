package com.healthcare.cats.features.cat.data.remote

import com.healthcare.cats.features.cat.data.remote.dto.CatDto
import retrofit2.http.GET

interface CatAPIService {
    @GET("/pets")
    suspend fun getCat(): List<CatDto>
}