package com.healthcare.cats.features.cat.data.remote.dto

data class CatDto(
    val body_condition_score: Int,
    val body_condition_score_reasons: String,
    val body_condition_score_timestamp: String,
    val breed_id: String,
    val country: String,
    val created_at: String,
    val date_of_birth: String,
    val description: String,
    val estimated_age_months: Int,
    val estimated_age_reasons: String,
    val estimated_age_timestamp: String,
    val estimated_size_classification: String,
    val estimated_weight_kg: Double,
    val estimated_weight_reasons: String,
    val estimated_weight_timestamp: String,
    val external_owner_id: String,
    val genealogy_result: GenealogyResult,
    val genealogy_timestamp: String,
    val id: String,
    val images: List<Image>,
    val microchip_id: String,
    val muscle_condition_reasons: String,
    val muscle_condition_timestamp: String,
    val muscle_wasting_risk: Boolean,
    val name: String,
    val neuter_status: String,
    val sex: String,
    val species_id: String,
    val sub_id: String,
    val updated_at: String
)

class GenealogyResult

data class Image(
    val age_months: Int,
    val age_years: Int,
    val created_at: String,
    val description: String,
    val height: Int,
    val id: String,
    val mime_type: String,
    val pet_age_months: Int,
    val pet_id: String,
    val portrait_style_id: String,
    val pose: String,
    val review_status: String,
    val upload_error: Boolean,
    val url: String,
    val width: Int
)