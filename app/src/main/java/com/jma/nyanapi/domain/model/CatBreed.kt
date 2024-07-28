package com.jma.nyanapi.domain.model

data class CatBreed (
    val id: String = "",
    val name: String = "",
    val origin: String = "",
    val description: String = "",
    val lifeSpan: String = "",
    val wikipediaUrl: String = "",
    val referenceImageId: String = "",
    var image: String = "",
    val weight: Weight = Weight(),
    val temperament: String = ""
)

data class Weight(
    val imperial: String = "",
    val metric: String = "",
)