package com.healthcare.cats.features.cat.data.remote.dto

import com.squareup.moshi.Json

data class CatDto(
    @Json(name = "bred_for") val bredFor: Any?,
    @Json(name = "breed_group") val breedGroup: String?,
    @Json(name = "country_code") val countryCode: String?,
    @Json(name = "country_codes") val countryCodes: String?,
    val description: String?,
    val height: Height?,
    val history: String?,
    val id: String?,
    val image: Image?,
    @Json(name = "life_span") val lifeSpan: String?,
    val name: String?,
    val origin: String?,
    @Json(name = "perfect_for") val perfectFor: Any?,
    @Json(name = "reference_image_id") val referenceImageId: String?,
    @Json(name = "species_id") val speciesId: String?,
    val temperament: String?,
    val weight: Weight?
)

data class Height(
    val imperial: String,
    val metric: String
)

data class Image(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

data class Weight(
    val imperial: String,
    val metric: String
)